DROP TABlE empleado CASCADE;

CREATE TABLE empleado (
	id_emp CHAR(15),
	passwd_emp VARCHAR(50) NOT NULL,
	nom_emp VARCHAR(100) NOT NULL,
	cargo_emp VARCHAR(20) NOT NULL,
	salario_emp NUMERIC NOT NULL,
	genero_emp CHAR(10) CHECK (genero_emp  = 'F' OR genero_emp  = 'M') NOT NULL,
	dir_emp VARCHAR(100) NOT NULL,
	tel_emp NUMERIC NOT NULL,
	email_emp VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_emp)
);
DROP TABlE cliente CASCADE;

CREATE TABLE cliente (
    id_cliente CHAR(15),
    tipo_id  VARCHAR(20) CHECK (tipo_id = 'CC' OR tipo_id = 'CE') NOT NULL,
    nom_cliente VARCHAR(100) NOT NULL,
    dir_cliente VARCHAR(100) NOT NULL,
    tel_cliente VARCHAR NOT NULL,
    email_cliente VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_cliente)
);

DROP TABlE proveedor CASCADE;

CREATE TABLE proveedor (
    nit_prov CHAR(15),
    razon_social_prov VARCHAR(100) NOT NULL,
    tel_prov VARCHAR(100) NOT NULL,
    dir_prov VARCHAR(100) NOT NULL,
    email_prov VARCHAR(50) NOT NULL,
    PRIMARY KEY (nit_prov)
);

DROP TABlE vehiculo CASCADE;

CREATE TABLE vehiculo (
    num_serie CHAR(15),
    anio_fab NUMERIC NOT NULL,
    num_chasis NUMERIC NOT NULL,
    num_motor NUMERIC NOT NULL,
    color VARCHAR(50) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    anio_garantia NUMERIC NOT NULL,
    km_garantia NUMERIC NOT NULL,
    cilindraje NUMERIC NOT NULL,
    costo NUMERIC NOT NULL,
    nit_prov CHAR(15),
    PRIMARY KEY (num_serie),
    FOREIGN KEY (nit_prov) REFERENCES proveedor (nit_prov)
);

DROP TABlE accesorio CASCADE;

CREATE TABLE accesorio (
    serial_acc CHAR(15),
    tipo_acc VARCHAR(50) NOT NULL,
    costo_acc NUMERIC NOT NULL,
    nit_prov CHAR(15),
    PRIMARY KEY (serial_acc),
    FOREIGN KEY (nit_prov) REFERENCES proveedor (nit_prov)
);

DROP TABlE tipo_servicio CASCADE;

CREATE TABLE tipo_servicio (
    id_serv CHAR(15),
    costo_serv NUMERIC NOT NULL,
    duracion_serv NUMERIC NOT NULL,
    descripcion_serv VARCHAR(1000) NOT NULL,
    PRIMARY KEY (id_serv)
);

DROP TABlE cotizacion CASCADE;

CREATE TABLE cotizacion (
    id_emp CHAR(15),
    id_cliente CHAR(15),
    num_serie CHAR(15),
    fecha_cot date NOT NULL,
    costo_cot NUMERIC NOT NULL,
    hora_cot VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (num_serie) REFERENCES vehiculo (num_serie)
);

DROP TABlE venta CASCADE;

CREATE TABLE venta (
    id_emp CHAR(15),
    id_cliente CHAR(15),
    num_serie CHAR(15),
    fecha_venta date NOT NULL,
    costo_venta NUMERIC NOT NULL,
    hora_venta VARCHAR(15) NOT NULL,
    tipo_pago VARCHAR(15) NOT NULL,
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (num_serie) REFERENCES vehiculo (num_serie)
);

DROP TABlE revision CASCADE;

CREATE TABLE revision (
    id_emp CHAR(15),
    id_cliente CHAR(15),
    fecha_ini date NOT NULL,
    fecha_fin date NOT NULL,
    duracion NUMERIC NOT NULL,
    placa_vehi VARCHAR(6) NULL,
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

DROP TABlE accesorio_por_revision CASCADE;

CREATE TABLE accesorio_por_revision (
    id_emp CHAR(15),
    id_cliente CHAR(15),
    serial_acc CHAR(15),
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (serial_acc) REFERENCES accesorio (serial_acc)
);

DROP TABlE servicio_por_revision CASCADE;

CREATE TABLE servicio_por_revision (
    id_emp CHAR(15),
    id_cliente CHAR(15),
    id_serv CHAR(15),
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_serv) REFERENCES tipo_servicio (id_serv)
);

DROP TABlE cuota CASCADE;

CREATE TABLE cuota (
    id_cuota CHAR(15),
    fecha_cuota date NOT NULL,
    hora_cuota VARCHAR(15) NOT NULL,
    abono_capital NUMERIC NOT NULL,
    interes NUMERIC NOT NULL,
    id_emp CHAR(15),
    id_cliente CHAR(15),
    num_serie CHAR(15),
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (num_serie) REFERENCES vehiculo (num_serie)
);
