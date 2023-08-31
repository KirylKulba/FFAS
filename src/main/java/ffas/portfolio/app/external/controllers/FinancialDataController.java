package ffas.portfolio.app.external.controllers;

import ffas.portfolio.app.business.finance.FinanceFacade;
import ffas.portfolio.app.business.finance.form.CreateFinanceDataForm;
import ffas.portfolio.app.business.finance.form.UpdateFinanceDataForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/finance")
public class FinancialDataController {
    private final FinanceFacade financialDataFacade;

    public FinancialDataController(@Qualifier("financeFacade") final FinanceFacade financialDataFacade) {
        this.financialDataFacade = financialDataFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveFinancialData(@RequestBody final CreateFinanceDataForm form) {
        return nonNull(financialDataFacade.save(form)) ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateFinancialData(@RequestBody final UpdateFinanceDataForm form) {
        return ResponseEntity.ok(financialDataFacade.update(form));
    }
}
