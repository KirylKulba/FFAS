package ffas.portfolio.app.external.controllers;

import ffas.portfolio.app.business.loan.LoanFacade;
import ffas.portfolio.app.business.loan.form.CreateLoanForm;
import ffas.portfolio.app.business.loan.form.UpdateLoanForm;
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
@RequestMapping("/loan")
public class LoanController {
    private final LoanFacade loanFacade;

    public LoanController(@Qualifier("loanFacade") final LoanFacade loanFacade) {
        this.loanFacade = loanFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveLoan(@RequestBody final CreateLoanForm form) {
        return nonNull(loanFacade.save(form)) ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateLoan(@RequestBody final UpdateLoanForm form) {
        return ResponseEntity.ok(loanFacade.update(form));
    }
}
