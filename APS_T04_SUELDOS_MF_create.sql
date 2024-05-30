
CREATE DATABASE APS_T04_SUELDOS_MF

USE APS_T04_SUELDOS_MF
GO

CREATE TABLE bonus (
    id_bonus int  NOT NULL,
    description VARCHAR(100)  NOT NULL,
    amount numeric(10,2)  NOT NULL,
    CONSTRAINT bonus_pk PRIMARY KEY  (id_bonus)
);

-- Table: contract_type
CREATE TABLE contract_type (
    id_contract_type int  NOT NULL,
    description VARCHAR(100)  NOT NULL,
    CONSTRAINT contract_type_pk PRIMARY KEY  (id_contract_type)
);

-- Table: department
CREATE TABLE department (
    department_id int  NOT NULL,
    name VARCHAR(100)  NOT NULL,
    description VARCHAR(255)  NOT NULL,
    CONSTRAINT department_pk PRIMARY KEY  (department_id)
);

-- Table: discount
CREATE TABLE discount (
    id_discount int  NOT NULL,
    description VARCHAR(100)  NOT NULL,
    amount numeric(10,2)  NOT NULL,
    CONSTRAINT discount_pk PRIMARY KEY  (id_discount)
);

-- Table: employee
CREATE TABLE employee (
    id_employee int  NOT NULL,
    name VARCHAR(100)  NOT NULL,
    last_name VARCHAR(100)  NOT NULL,
    dni VARCHAR(8)  NOT NULL,
    birth_date date  NOT NULL,
    address VARCHAR(255)  NOT NULL,
    phone VARCHAR(9)  NOT NULL,
    email VARCHAR(255)  NOT NULL,
    hiring_date date  NOT NULL,
    department_department_id int  NOT NULL,
    contract_type_id_contract_type int  NOT NULL,
    position_id_position int  NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY  (id_employee)
);

-- Table: payroll
CREATE TABLE payroll (
    id_payroll int NOT NULL,
    period_date date NOT NULL,
    generation_date date NOT NULL,
    CONSTRAINT payroll_pk PRIMARY KEY (id_payroll)
);;

-- Table: payroll_detail
CREATE TABLE payroll_detail (
    id_payroll_detail int  NOT NULL,
    gross_salary numeric(10,2)  NOT NULL,
    deductions numeric(10,2)  NOT NULL,
    net_salary numeric(10,2)  NOT NULL,
    bonuses numeric(10,2)  NOT NULL,
    payment_date date  NOT NULL,
    payroll_id_payroll int  NOT NULL,
    employee_id_employee int  NOT NULL,
    CONSTRAINT payroll_detail_pk PRIMARY KEY  (id_payroll_detail)
);

-- Table: position
CREATE TABLE position (
    id_position int  NOT NULL,
    name VARCHAR(100)  NOT NULL,
    description VARCHAR(255)  NOT NULL,
    base_salary numeric(10,2)  NOT NULL,
    CONSTRAINT position_pk PRIMARY KEY  (id_position)
);

-- foreign keys
-- Reference: employee_contract_type (table: employee)
ALTER TABLE employee ADD CONSTRAINT employee_contract_type
    FOREIGN KEY (contract_type_id_contract_type)
    REFERENCES contract_type (id_contract_type);

-- Reference: employee_department (table: employee)
ALTER TABLE employee ADD CONSTRAINT employee_department
    FOREIGN KEY (department_department_id)
    REFERENCES department (department_id);

-- Reference: employee_position (table: employee)
ALTER TABLE employee ADD CONSTRAINT employee_position
    FOREIGN KEY (position_id_position)
    REFERENCES position (id_position);

-- Reference: payroll_detail_employee (table: payroll_detail)
ALTER TABLE payroll_detail ADD CONSTRAINT payroll_detail_employee
    FOREIGN KEY (employee_id_employee)
    REFERENCES employee (id_employee);

-- Reference: payroll_detail_payroll (table: payroll_detail)
ALTER TABLE payroll_detail ADD CONSTRAINT payroll_detail_payroll
    FOREIGN KEY (payroll_id_payroll)
    REFERENCES payroll (id_payroll);




INSERT INTO employee
(id_employee, name, last_name, dni, birth_date, address, phone, email, hiring_date, department_department_id, contract_type_id_contract_type, position_id_position)
VALUES
('1', 'Juan', 'Perez', '12345678','1990-01-01', 'Calle Principal 123', '123456789', 'juan.perez@email.com', '2023-01-30', '1', '1', '1');
GO

SELECT * FROM employee

DELETE FROM employee
    WHERE id_employee = '2'
GO

INSERT INTO department
(department_id, name, description)
VALUES
('1', 'Marketing', 'Equipo responsable de las estrategias de marketing de la empresa.'),
('2', 'Ventas', 'Equipo responsable de las ventas y la generación de ingresos para la empresa.'),
('3', 'Recursos Humanos', 'Equipo responsable de la gestión del personal, la contratación y la administración de la nómina.'),
('4', 'Finanzas', 'Equipo responsable de la gestión financiera de la empresa.'),
('5', 'Tecnología de la Información', 'Equipo responsable de la infraestructura y los sistemas informáticos de la empresa.');
GO

SELECT * FROM department

INSERT INTO contract_type
(id_contract_type, description)
VALUES
('1', 'Tiempo completo'),
('2', 'Tiempo parcial'),
('3', 'Indefinido'),
('4', 'Obra o servicio determinado'),
('5', 'Prácticas'),
('6', 'Temporada');
GO

SELECT * FROM contract_type

INSERT INTO position
(id_position, name, description, base_salary)
VALUES
('1', 'Desarrollador de Software', 'Responsable del diseño, desarrollo y mantenimiento de aplicaciones informáticas.', '5000.00'),
('2', 'Analista de Sistemas', 'Responsable del análisis, diseño e implementación de sistemas informáticos.', '4500.00'),
('3', 'Administrador de Redes', 'Responsable de la instalación, configuración y mantenimiento de redes informáticas.', '4000.00'),
('4', 'Técnico de Soporte Informático', 'Responsable de brindar soporte técnico a los usuarios de sistemas informáticos.', '3500.00'),
('5', 'Contador', 'Responsable de la gestión contable y financiera de la empresa.', '4200.00'),
('6', 'Vendedor', 'Responsable de la venta de productos o servicios de la empresa.', '3800.00');
GO

SELECT * FROM position



