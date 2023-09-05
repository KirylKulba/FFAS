CREATE TRIGGER calculate_emi_before_insert
BEFORE INSERT ON loans
FOR EACH ROW
EXECUTE FUNCTION calculate_emi();

CREATE TRIGGER calculate_emi_before_update
BEFORE UPDATE ON loans
FOR EACH ROW
EXECUTE FUNCTION calculate_emi();

