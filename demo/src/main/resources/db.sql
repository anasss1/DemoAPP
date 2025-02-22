CREATE TABLE users (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR2(255) NOT NULL,
    password VARCHAR2(255) NOT NULL,
    role VARCHAR2(255) NOT NULL
);

CREATE TABLE tickets (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR2(255) NOT NULL,
    description VARCHAR2(500),
    priority VARCHAR2(255),
    category VARCHAR2(255),
    status VARCHAR2(255) DEFAULT 'New',
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id NUMBER,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE audit_logs (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    action_type VARCHAR2(255),
    description VARCHAR2(500),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ticket_id NUMBER,
    user_id NUMBER,
    CONSTRAINT fk_ticket FOREIGN KEY (ticket_id) REFERENCES tickets(id),
    CONSTRAINT fk_audit_user FOREIGN KEY (user_id) REFERENCES users(id)
);
