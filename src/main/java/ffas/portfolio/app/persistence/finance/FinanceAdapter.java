package ffas.portfolio.app.persistence.finance;

import ffas.portfolio.app.business.common.exceptions.NotFoundException;
import ffas.portfolio.app.business.finance.dto.FinancialDataDto;
import ffas.portfolio.app.business.finance.form.CreateFinanceDataForm;
import ffas.portfolio.app.business.finance.form.UpdateFinanceDataForm;
import ffas.portfolio.app.business.finance.port.FinancePort;
import ffas.portfolio.app.persistence.user.User;
import ffas.portfolio.app.persistence.user.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
class FinanceAdapter implements FinancePort {

    private final FinancialDataRepository financeRepository;
    private final FinancialDataTypeRepository financialTypeRepository;
    private final UserRepository userRepository;
    private EntityManager entityManager;

    private final int BATCH_SIZE = 50;

    public FinanceAdapter(final UserRepository userRepository,
                          final FinancialDataTypeRepository financialTypeRepository,
                          final FinancialDataRepository financeRepository,
                          final EntityManager entityManager){
        this.userRepository = userRepository;
        this.financeRepository = financeRepository;
        this.financialTypeRepository = financialTypeRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public FinancialDataDto save(final CreateFinanceDataForm createFinanceForm) {
        final FinancialData financialData = toEntity(createFinanceForm);
        final FinancialData newFinancialRecord = financeRepository.save(financialData);
        return toDto(newFinancialRecord);
    }

    @Override
    @Transactional
    public void saveAll(final List<CreateFinanceDataForm> financialData) {
        try {
            for (int i = 0; i < financialData.size(); i++) {
                entityManager.persist(toEntity(financialData.get(i)));

                if (i % BATCH_SIZE == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
        } catch (final PersistenceException ex) {
            // Later log the exception
        }
    }

    @Override
    @Transactional
    public FinancialDataDto update(final UpdateFinanceDataForm updateFinanceForm) {
        final FinancialData data = financeRepository.findByUuid(updateFinanceForm.getUuid())
                .orElseThrow(() -> new NotFoundException("Financial data not found with uuid: " + updateFinanceForm.getUuid().toString()));
        updateValues(data, updateFinanceForm);
        final FinancialData updatedData = financeRepository.save(data);
        return toDto(updatedData);
    }

    private void updateValues(final FinancialData currentData, final UpdateFinanceDataForm newData) {
        currentData.setDate(newData.getDate());
        currentData.setAmount(newData.getAmount());
        currentData.setDescription(newData.getDescription());
        currentData.setFinancialDataType(getFinancialDataTypeByName(newData.getType()));
    }

    private FinancialDataType getFinancialDataTypeByName(final String type) {
        return financialTypeRepository.findByTypeName(FinancialDataType.Type.valueOf(type))
                .orElseThrow(() -> new NotFoundException("Financial data type not found with name: " + type));
    }

    private FinancialData toEntity(final CreateFinanceDataForm form) {
        final FinancialData newFinancialData = new FinancialData();
        newFinancialData.setFinancialDataType(getFinancialDataTypeByName(form.getType()));
        newFinancialData.setDate(form.getDate());
        newFinancialData.setAmount(form.getAmount());
        newFinancialData.setDescription(form.getDescription());
        newFinancialData.setUser(findUserByUuid(form.getUser()));
        return newFinancialData;
    }

    private User findUserByUuid(final UUID uuid) {
        return userRepository.findUserByUuid(uuid)
                .orElseThrow(() -> new NotFoundException("User not found with uuid: " + uuid));
    }

    private FinancialDataDto toDto(final FinancialData data) {
        final FinancialDataDto dto = new FinancialDataDto();
        dto.setType(data.getFinancialDataType().toString());
        dto.setAmount(data.getAmount());
        dto.setDescription(data.getDescription());
        dto.setUser(data.getUser().getUuid());
        return dto;
    }
}
