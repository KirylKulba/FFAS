CREATE OR REPLACE FUNCTION calculate_emi()
RETURNS TRIGGER AS $$
BEGIN
    NEW.emi = NEW.principal_amount * NEW.interest_rate
                  * calculate_compound_int_factor(NEW.start_date, NEW.end_date, NEW.interest_rate);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION months_between_days(start_date DATE,
                                               end_date DATE)
RETURNS INTEGER AS $$
BEGIN
RETURN (EXTRACT (YEAR FROM end_date) - EXTRACT (YEAR FROM start_date)) * 12 +
       (EXTRACT (MONTH FROM end_date) - EXTRACT (MONTH FROM start_date));
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION calculate_emi_compound_int_factor(start_date DATE,
                                                         end_date DATE,
                                                         interest_rate FLOAT)
RETURNS FLOAT AS $$
BEGIN
RETURN ((1 + interest_rate)^months_between_days(start_date, end_date))/
    (((1 + interest_rate)^months_between_days(start_date, end_date))-1);
END;
$$ LANGUAGE plpgsql;