CREATE DATABASE FINANTEL;
GO
USE FINANTEL;
GO
CREATE TABLE Usuarios (
    id INT PRIMARY KEY IDENTITY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    rol VARCHAR(50),
    estado VARCHAR(20),
    intentos INT,
    ultimo_acceso DATETIME,
    dni VARCHAR(20),
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    fecha_registro DATETIME,
    fecha_ultimo_acceso DATETIME,
    cargo VARCHAR(100)
);
CREATE TABLE Respaldos (
  id INT IDENTITY(1,1) PRIMARY KEY,
  fecha DATETIME DEFAULT GETDATE(),
  tipo VARCHAR(50),
  tamanio VARCHAR(20),
  usuario VARCHAR(100),
  estado VARCHAR(20)
)
USE FINANTEL;
CREATE TABLE ConfigRespaldos (
  tipo VARCHAR(20) PRIMARY KEY,
  activo BIT DEFAULT 1
);
INSERT INTO ConfigRespaldos VALUES ('Diario', 1), ('Semanal', 1), ('Mensual', 1);
INSERT INTO ConfigRespaldos VALUES ('Diario', 1), ('Semanal', 1), ('Mensual', 1)
CREATE TABLE CuentasContables (
    codigo VARCHAR(10) PRIMARY KEY,
    descripcion VARCHAR(200),
    clasificacion VARCHAR(50),
    tipo VARCHAR(20),
    estado VARCHAR(20),
    ops_autorizadas VARCHAR(100)
);

CREATE TABLE PeriodosContables (
    id INT PRIMARY KEY IDENTITY,
    periodo VARCHAR(20),
    fecha_inicio DATE,
    fecha_cierre DATE,
    estado VARCHAR(20),
    cerrado_por VARCHAR(100)
);

CREATE TABLE AsientosContables (
    id INT PRIMARY KEY IDENTITY,
    fecha DATETIME,
    tipo VARCHAR(50),
    descripcion VARCHAR(200),
    debe DECIMAL(18,2),
    haber DECIMAL(18,2),
    estado VARCHAR(20),
    usuario VARCHAR(100),
    periodo_id INT,
    numero_correlativo VARCHAR(20),
    cuenta_contable VARCHAR(20),
    centro_costo VARCHAR(50),
    moneda VARCHAR(10),
    tipo_cambio DECIMAL(10,4),
    glosa VARCHAR(500),
    referencia_documento VARCHAR(50),
    fecha_registro DATETIME,
    fecha_modificacion DATETIME
);

CREATE TABLE Comprobantes (
    id INT PRIMARY KEY IDENTITY,
    numero VARCHAR(20),
    fecha DATE,
    tipo VARCHAR(50),
    cliente VARCHAR(100),
    monto DECIMAL(18,2),
    estado VARCHAR(20)
);

CREATE TABLE CentrosCosto (
    id INT PRIMARY KEY IDENTITY,
    nombre VARCHAR(100),
    presupuesto DECIMAL(18,2),
    ejecutado DECIMAL(18,2),
    estado VARCHAR(20)
);

CREATE TABLE TipoCambio (
    id INT PRIMARY KEY IDENTITY,
    fecha DATE,
    compra DECIMAL(10,4),
    venta DECIMAL(10,4),
    fuente VARCHAR(50),
    estado VARCHAR(20)
);

CREATE TABLE AuditoriaAcciones (
    id INT PRIMARY KEY IDENTITY,
    fecha DATETIME,
    usuario VARCHAR(100),
    accion VARCHAR(100),
    objeto VARCHAR(100),
    valor_anterior VARCHAR(500),
    valor_nuevo VARCHAR(500)
);

CREATE TABLE MovimientosBancarios (
    id INT PRIMARY KEY IDENTITY,
    fecha DATE,
    descripcion VARCHAR(200),
    monto DECIMAL(18,2),
    tipo VARCHAR(50),
    estado VARCHAR(20)
);
-- CONSTRAINTS
ALTER TABLE Usuarios ADD CONSTRAINT UQ_Usuarios_Email UNIQUE (email);
ALTER TABLE AsientosContables ADD CONSTRAINT FK_Asientos_Periodos FOREIGN KEY (periodo_id) REFERENCES PeriodosContables(id);
ALTER TABLE AsientosContables ADD CONSTRAINT FK_Asientos_Usuarios FOREIGN KEY (usuario) REFERENCES Usuarios(email);
ALTER TABLE AsientosContables ADD CONSTRAINT FK_Asientos_Cuentas FOREIGN KEY (cuenta_contable) REFERENCES CuentasContables(codigo);
ALTER TABLE AuditoriaAcciones ADD CONSTRAINT FK_Auditoria_Usuarios FOREIGN KEY (usuario) REFERENCES Usuarios(email);

-- DATOS
INSERT INTO Usuarios (nombre, email, password, rol, estado, intentos, ultimo_acceso, dni, telefono, direccion, fecha_registro, fecha_ultimo_acceso, cargo)
VALUES 
('fredi', 'fredi@finantel.pe', '$2a$10$ua.GQKa.Xz4ni/DU.eP7V.OnOCnzVxoGTwTEHk8kvAXeIAOQupTya', 'Contador General', 'Activo', 0, GETDATE(), '70123456', '987654321', 'Chorrillos', GETDATE(), GETDATE(), 'Contador General'),
('diego', 'admin@finantel.pe', '$2a$10$zLZ7iJ49agNCOzzIge9qhunjkO.WymtC.qxivr4xwXsHydwYkc6bG', 'Administrador', 'Activo', 0, GETDATE(), '70234567', '987654322', 'Chorrillos', GETDATE(), GETDATE(), 'Administrador'),
('samir', 'auditor@finantel.pe', '$2a$10$ua.GQKa.Xz4ni/DU.eP7V.OnOCnzVxoGTwTEHk8kvAXeIAOQupTya', 'Auditor', 'Activo', 0, GETDATE(), '70345678', '987654323', 'Chorrillos', GETDATE(), GETDATE(), 'Auditor Senior'),
('alexis', 'Alexis@finantel.pe', '$2a$10$MIgiSLps6nZML1KAeC8Lte51phhpk4.LHBoaFIxRzDt0/EVmMlODW', 'Personal Autorizado', 'Activo', 0, GETDATE(), '70456789', '987654324', 'Las Planicias', GETDATE(), GETDATE(), 'Personal Autorizado');

INSERT INTO CuentasContables (codigo, descripcion, clasificacion, tipo, estado, ops_autorizadas)
VALUES
('1011', 'Caja', 'Activo', 'Debito', 'Activo', 'Todas'),
('2011', 'Almacén', 'Activo', 'Debito', 'Activo', 'Todas'),
('4011', 'Tributos por pagar', 'Pasivo', 'Credito', 'Activo', 'Todas'),
('5011', 'Capital social', 'Patrimonio', 'Credito', 'Activo', 'Todas');

INSERT INTO PeriodosContables (periodo, fecha_inicio, fecha_cierre, estado, cerrado_por)
VALUES
('2025-01', '2025-01-01', '2025-01-31', 'Cerrado', 'fredi@finantel.pe'),
('2025-02', '2025-02-01', '2025-02-28', 'Cerrado', 'fredi@finantel.pe'),
('2025-03', '2025-03-01', '2025-03-31', 'Activo', 'fredi@finantel.pe');

INSERT INTO AsientosContables (fecha, tipo, descripcion, debe, haber, estado, usuario, periodo_id, numero_correlativo, cuenta_contable, centro_costo, moneda, tipo_cambio, glosa, referencia_documento, fecha_registro, fecha_modificacion)
VALUES
(GETDATE(), 'Apertura', 'Asiento de apertura 2025', 5000.00, 5000.00, 'Activo', 'fredi@finantel.pe', 3, 'AS-2025-001', '1011', 'Caja', 'PEN', 1.0000, 'Asiento de apertura 2025', 'F001-1001', GETDATE(), GETDATE()),
(GETDATE(), 'Operación ordinaria', 'Pago de tributos', 1500.00, 1500.00, 'Activo', 'fredi@finantel.pe', 3, 'AS-2025-002', '4011', 'Tributos', 'PEN', 1.0000, 'Pago de tributos', 'F001-1002', GETDATE(), GETDATE()),
(GETDATE(), 'Ajuste', 'Ajuste de inventario', 800.00, 800.00, 'Activo', 'fredi@finantel.pe', 3, 'AS-2025-003', '2011', 'Almacén', 'PEN', 1.0000, 'Ajuste de inventario', 'F001-1003', GETDATE(), GETDATE()),
(GETDATE(), 'Apertura', 'COPIA - Asiento de apertura 2025', 5000.00, 4500.00, 'Activo', 'fredi@finantel.pe', 3, 'AS-2025-004', '1011', 'Caja', 'PEN', 1.0000, 'COPIA - Asiento de apertura 2025', 'COPIA-F001-1001', GETDATE(), GETDATE());

INSERT INTO Comprobantes (numero, fecha, tipo, cliente, monto, estado)
VALUES
('F001-001', GETDATE(), 'Factura', 'Cliente ABC SAC', 1180.00, 'Emitido'),
('B001-001', GETDATE(), 'Boleta', 'Cliente XYZ', 590.00, 'Emitido'),
('F001-002', GETDATE(), 'Factura', 'Empresa DEF EIRL', 2360.00, 'Emitido');

INSERT INTO CentrosCosto (nombre, presupuesto, ejecutado, estado)
VALUES
('Administración', 50000.00, 25000.00, 'Activo'),
('Contabilidad', 30000.00, 15000.00, 'Activo'),
('Sistemas', 20000.00, 8000.00, 'Activo');

INSERT INTO TipoCambio (fecha, compra, venta, fuente, estado)
VALUES
(GETDATE(), 3.7500, 3.7800, 'SBS', 'Activo'),
(DATEADD(day,-1,GETDATE()), 3.7400, 3.7700, 'SBS', 'Activo'),
(DATEADD(day,-2,GETDATE()), 3.7300, 3.7600, 'SBS', 'Activo');

INSERT INTO AuditoriaAcciones (fecha, usuario, accion, objeto, valor_anterior, valor_nuevo)
VALUES
(GETDATE(), 'fredi@finantel.pe', 'Login exitoso', 'Usuarios', NULL, 'Sesión iniciada'),
(GETDATE(), 'admin@finantel.pe', 'Creación', 'AsientosContables', NULL, 'Asiento #1 creado'),
(GETDATE(), 'fredi@finantel.pe', 'Edición', 'AsientosContables', 'Estado: Activo', 'Estado: Inactivo');

INSERT INTO MovimientosBancarios (fecha, descripcion, monto, tipo, estado)
VALUES
(GETDATE(), 'Depósito cliente ABC', 5000.00, 'Ingreso', 'Conciliado'),
(GETDATE(), 'Pago proveedor XYZ', 2500.00, 'Egreso', 'Conciliado'),
(GETDATE(), 'Transferencia bancaria', 1800.00, 'Ingreso', 'Pendiente');

--------------------
UPDATE Usuarios SET rol = 'Contador_General' WHERE rol = 'Contador General';
UPDATE Usuarios SET rol = 'Personal_Autorizado' WHERE rol = 'Personal Autorizado';

INSERT INTO AsientosContables (tipo, descripcion, debe, haber, estado, usuario, [cuenta_contable], moneda, tipo_cambio)
VALUES ('Operación ordinaria', 'Pago de tributos - gasto', 1500.00, 0.00, 'Activo', 'admin@finantel.pe', '4011', 'PEN', 1.0)

INSERT INTO AsientosContables (tipo, descripcion, debe, haber, estado, usuario, [cuenta_contable], moneda, tipo_cambio)
VALUES ('Operación ordinaria', 'Pago de tributos - caja', 0.00, 1500.00, 'Activo', 'admin@finantel.pe', '1011', 'PEN', 1.0)

INSERT INTO CuentasContables (codigo, descripcion, clasificacion, tipo, estado, ops_autorizadas)
VALUES ('5011', 'Ingresos por servicios', 'Ingresos', 'Credito', 'Activo', 'Todas')

INSERT INTO CuentasContables (codigo, descripcion, clasificacion, tipo, estado, ops_autorizadas)
VALUES ('4501', 'Gastos administrativos', 'Gastos', 'Debito', 'Activo', 'Todas')

INSERT INTO AsientosContables (tipo, descripcion, debe, haber, estado, usuario, [cuenta_contable], moneda, tipo_cambio)
VALUES ('Operación ordinaria', 'Ingresos por servicios', 0.00, 5000.00, 'Activo', 'admin@finantel.pe', '5011', 'PEN', 1.0)

INSERT INTO AsientosContables (tipo, descripcion, debe, haber, estado, usuario, [cuenta_contable], moneda, tipo_cambio)
VALUES ('Operación ordinaria', 'Gastos administrativos', 2000.00, 0.00, 'Activo', 'admin@finantel.pe', '4501', 'PEN', 1.0)

--Para el Estado de Resultados
-- Ingresos - crédito
INSERT INTO AsientosContables (tipo, descripcion, debe, haber, estado, usuario, [cuenta_contable], moneda, tipo_cambio)
VALUES ('Operación ordinaria', 'Ingresos por servicios', 0.00, 5000.00, 'Activo', 'admin@finantel.pe', '5011', 'PEN', 1.0)

-- Gastos  - débito
INSERT INTO AsientosContables (tipo, descripcion, debe, haber, estado, usuario, [cuenta_contable], moneda, tipo_cambio)
VALUES ('Operación ordinaria', 'Gastos administrativos', 2000.00, 0.00, 'Activo', 'admin@finantel.pe', '4501', 'PEN', 1.0)
-- Primero agregar la cuenta en CuentasContables
INSERT INTO CuentasContables (codigo, descripcion, clasificacion, tipo, estado, ops_autorizadas)
VALUES ('3011', 'Capital Social', 'Patrimonio', 'Credito', 'Activo', 'Todas')

-- Luego el asiento
INSERT INTO AsientosContables (tipo, descripcion, debe, haber, estado, usuario, [cuenta_contable], moneda, tipo_cambio)
VALUES ('Apertura', 'Capital social inicial', 0.00, 50000.00, 'Activo', 'admin@finantel.pe', '3011', 'PEN', 1.0)

INSERT INTO AsientosContables (fecha, tipo, descripcion, debe, haber, estado, usuario, cuenta_contable, moneda, tipo_cambio) 
VALUES (GETDATE(), 'Apertura', 'Depósito inicial', 0, 50000, 'Activo', 'fredi@finantel.pe', '2011', 'PEN', 1.0)


-- Asientos de junio  
INSERT INTO AsientosContables (fecha, tipo, descripcion, debe, haber, estado, usuario, cuenta_contable, moneda, tipo_cambio, numero_correlativo)
VALUES 
(GETDATE(), 'Operación ordinaria', 'Cobro cuota crédito', 5000, 0, 'Activo', 'fredi@finantel.pe', '1011', 'PEN', 1.0, 'AS-2026-101'),
(GETDATE(), 'Operación ordinaria', 'Pago planilla junio', 0, 3000, 'Activo', 'fredi@finantel.pe', '4501', 'PEN', 1.0, 'AS-2026-102'),
(GETDATE(), 'Operación ordinaria', 'Ingreso por intereses', 0, 2000, 'Activo', 'fredi@finantel.pe', '5011', 'PEN', 1.0, 'AS-2026-103'),
(GETDATE(), 'Operación ordinaria', 'Depósito cliente', 8000, 0, 'Activo', 'fredi@finantel.pe', '1011', 'PEN', 1.0, 'AS-2026-104')

SELECT numero_correlativo, fecha, fecha_registro, MONTH(fecha_registro) as mes 
FROM AsientosContables 
WHERE numero_correlativo IN ('AS-2026-101','AS-2026-102','AS-2026-103','AS-2026-104')

UPDATE Usuarios SET password = '$2a$10$MIgiSLps6nZML1KAeC8Lte51phhpk4.LHBoaFIxRzDt0/EVmMlODW' WHERE email = 'Alexis@finantel.pe'

INSERT INTO ConfigRespaldos VALUES ('Diario', 1), ('Semanal', 1), ('Mensual', 1);
ALTER TABLE TipoCambio ADD moneda VARCHAR(10) DEFAULT 'USD';
UPDATE TipoCambio SET moneda = 'USD' WHERE moneda IS NULL;
INSERT INTO TipoCambio (fecha, compra, venta, fuente, estado, moneda) VALUES 
(GETDATE(), 3.68, 3.72, 'SBS', 'Activo', 'EUR'),
(GETDATE(), 0.19, 0.21, 'SBS', 'Activo', 'MXN');