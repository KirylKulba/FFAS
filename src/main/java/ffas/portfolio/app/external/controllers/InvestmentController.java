package ffas.portfolio.app.external.controllers;

import ffas.portfolio.app.business.Investment.InvestmentFacade;
import ffas.portfolio.app.business.Investment.form.CreateInvestmentForm;
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
@RequestMapping("/investment")
public class InvestmentController {
    private final InvestmentFacade investmentFacade;

    public InvestmentController(@Qualifier("investmentFacade") final InvestmentFacade investmentFacade) {
        this.investmentFacade = investmentFacade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveInvestment(@RequestBody final CreateInvestmentForm form) {
        return nonNull(investmentFacade.save(form)) ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
