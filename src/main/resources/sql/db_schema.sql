CREATE
    SEQUENCE IF NOT EXISTS hibernate_sequence;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Users Table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT uuid_generate_v4(),
    citizen_number VARCHAR(255) NOT NULL UNIQUE,
    sex VARCHAR(50) CHECK (sex IN ('Male', 'Female', 'Other')),
    age INT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);

-- Investment Types Table
CREATE TABLE investment_types (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE financial_data_types (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(50) CHECK (type_name IN ('Income', 'Expense'))
);

CREATE TABLE financial_data (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT uuid_generate_v4(),
    user_id INT,
    type_id INT,
    amount DECIMAL(20,2) DEFAULT 0,
    date DATE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    FOREIGN KEY (type_id) REFERENCES financial_data_types(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Investments Table
CREATE TABLE investments (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT uuid_generate_v4(),
    user_id INT,
    type_id INT,
    amount DECIMAL(20,2),
    returns DECIMAL(20,2),
    investment_date DATE,
    maturity_date DATE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (type_id) REFERENCES investment_types(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Loans Table
CREATE TABLE loans (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT uuid_generate_v4(),
    user_id INT,
    principal_amount DECIMAL(20,2),
    interest_rate DECIMAL(5,2),
    start_date DATE,
    end_date DATE,
    emi DECIMAL(20,2),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);