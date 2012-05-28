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
    id_cliente char(15),
    tipo_id  varchar(20) CHECK (tipo_id = 'CC' OR tipo_id = 'CE') NOT NULL,
    nom_cliente varchar(100) NOT NULL,
    dir_cliente varchar(100) NOT NULL,
    tel_cliente varchar NOT NULL,
    email_cliente varchar(50) NOT NULL,
    PRIMARY KEY (id_cliente)
);

DROP TABlE proveedor CASCADE;

CREATE TABLE proveedor (
    nit_prov char(15),
    razon_social_prov varchar(100) NOT NULL,
    tel_prov varchar(100) NOT NULL,
    dir_prov varchar(100) NOT NULL,
    email_prov varchar(50) NOT NULL,
    PRIMARY KEY (nit_prov)
);

DROP TABlE vehiculo CASCADE;

CREATE TABLE vehiculo (
    num_serie char(15),
    anio_fab numeric NOT NULL,
    num_chasis numeric NOT NULL,
    num_motor numeric NOT NULL,
    color varchar(50) NOT NULL,
    marca varchar(30) NOT NULL,
    anio_garantia numeric NOT NULL,
    km_garantia numeric NOT NULL,
    cilindraje numeric NOT NULL,
    costo numeric NOT NULL,
    nit_prov char(15),
    PRIMARY KEY (num_serie),
    FOREIGN KEY (nit_prov) REFERENCES proveedor (nit_prov)
);

DROP TABlE accesorio CASCADE;

CREATE TABLE accesorio (
    serial_acc char(15),
    tipo_acc varchar(50) NOT NULL,
    costo_acc numeric NOT NULL,
    nit_prov char(15),
    PRIMARY KEY (serial_acc),
    FOREIGN KEY (nit_prov) REFERENCES proveedor (nit_prov)
);

DROP TABlE tipo_servicio CASCADE;

CREATE TABLE tipo_servicio (
    id_serv char(15),
    costo_serv numeric NOT NULL,
    duracion_serv numeric NOT NULL,
    descripcion_serv varchar(1000) NOT NULL,
    PRIMARY KEY (id_serv)
);

DROP TABlE cotizacion CASCADE;

CREATE TABLE cotizacion (
    id_emp char(15),
    id_cliente char(15),
    num_serie char(15),
    fecha_cot date NOT NULL,
    costo_cot numeric NOT NULL,
    hora_cot varchar(15) NOT NULL,
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (num_serie) REFERENCES vehiculo (num_serie)
);

DROP TABlE venta CASCADE;

CREATE TABLE venta (
    id_emp char(15),
    id_cliente char(15),
    num_serie char(15),
    fecha_venta date NOT NULL,
    costo_venta numeric NOT NULL,
    hora_venta varchar(15) NOT NULL,
    tipo_pago varchar(15) NOT NULL,
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (num_serie) REFERENCES vehiculo (num_serie)
);

DROP TABlE revision CASCADE;

CREATE TABLE revision (
    id_emp char(15),
    id_cliente char(15),
    fecha_ini date NOT NULL,
    fecha_fin date NOT NULL,
    duracion NUMERIC NOT NULL,
    placa_vehi varchar(6) NULL,
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

DROP TABlE accesorio_por_revision CASCADE;

CREATE TABLE accesorio_por_revision (
    id_emp char(15),
    id_cliente char(15),
    serial_acc char(15),
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (serial_acc) REFERENCES accesorio (serial_acc)
);

DROP TABlE servicio_por_revision CASCADE;

CREATE TABLE servicio_por_revision (
    id_emp char(15),
    id_cliente char(15),
    id_serv char(15),
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (id_serv) REFERENCES tipo_servicio (id_serv)
);

DROP TABlE cuota CASCADE;

CREATE TABLE cuota (
    id_cuota char(15),
    fecha_cuota date NOT NULL,
    hora_cuota varchar(15) NOT NULL,
    abono_capital numeric NOT NULL,
    interes numeric NOT NULL,
    id_emp char(15),
    id_cliente char(15),
    num_serie char(15),
    FOREIGN KEY (id_emp) REFERENCES empleado (id_emp),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
    FOREIGN KEY (num_serie) REFERENCES vehiculo (num_serie)
);
