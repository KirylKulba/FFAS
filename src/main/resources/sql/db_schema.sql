-- Roles Table
CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

-- Users Table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    role_id INT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    last_login TIMESTAMP,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Investment Types Table
CREATE TABLE investment_types (
    type_id SERIAL PRIMARY KEY,
    type_name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE financial_data_types (
    type_id SERIAL PRIMARY KEY,
    type_name VARCHAR(50) CHECK (type_name IN ('income', 'expense'))
);

-- Financial Data Table (Normalized further for income and expenses)
CREATE TABLE financial_data (
    data_id SERIAL PRIMARY KEY,
    user_id INT,
    type_id INT,
    amount DECIMAL(20,2) DEFAULT 0,
    date_month DATE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    FOREIGN KEY (type_id) REFERENCES investment_types(type_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Investments Table
CREATE TABLE investments (
    investment_id SERIAL PRIMARY KEY,
    user_id INT,
    type_id INT,
    amount DECIMAL(20,2),
    returns DECIMAL(20,2),
    investment_date DATE,
    maturity_date DATE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (type_id) REFERENCES investment_types(type_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Loans Table
CREATE TABLE loans (
    loan_id SERIAL PRIMARY KEY,
    user_id INT,
    principal_amount DECIMAL(20,2),
    interest_rate DECIMAL(5,2),
    start_date DATE,
    end_date DATE,
    emi DECIMAL(20,2),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);