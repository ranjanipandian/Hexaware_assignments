CREATE TABLE customer (
    customerId INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(255),
    creditScore INT
);

CREATE TABLE loan (
    loanId INT PRIMARY KEY,
    customerId INT,
    principal DOUBLE,
    rate DOUBLE,
    term INT,
    type VARCHAR(20),
    status VARCHAR(20),
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
);
