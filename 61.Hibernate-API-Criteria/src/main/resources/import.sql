INSERT INTO clientes (nombre, apellido, forma_pago, creado_en, editado_en)
VALUES ('Dieguito', 'rodriguez', 'debito', NULL, NULL),
       ('Pepe', 'Roe', 'paypa', NULL, NULL),
       ('pepe', 'rodriguez', 'criptos', NULL, NULL),
       ('Nombre cambiado', 'Lela', 'dinero', NULL, NULL),
       ('LALO', 'PEPE', 'cash', NULL, NULL);
--
-- INSERT INTO alumnos (id, nombre, apellido) VALUES(1, 'Johana', 'Doe');
-- INSERT INTO alumnos (id, nombre, apellido) VALUES(2, 'Pepe', 'Gon');
-- INSERT INTO cursos (id, titulo, profesor) VALUES(1, 'Curso Java', 'Andres');
-- INSERT INTO cursos (id, titulo, profesor) VALUES(2, 'Hibernate', 'Andres');
-- --
-- INSERT INTO direcciones(calle, numero) VALUES('vaticano', 123);
-- INSERT INTO direcciones(calle, numero) VALUES('colon', 456);
-- INSERT INTO clientes_direcciones(cliente_id, direccion_id) VALUES (1, 1);
-- INSERT INTO clientes_detalles (prime, puntos_acumulados, cliente_detatlle_id) VALUES (1, 8000, 1);
-- INSERT INTO alumnos_cursos (alumno_id, curso_id) VALUES (1, 1);
-- INSERT INTO alumnos_cursos (alumno_id, curso_id) VALUES (1, 2);

INSERT INTO facturas (descripcion, total, id_cliente) VALUES ('oficina', 4000, 1);
INSERT INTO facturas (descripcion, total, id_cliente) VALUES ('casa', 2000, 1);
INSERT INTO facturas (descripcion, total, id_cliente) VALUES ('deporte', 3000, 1);
INSERT INTO facturas (descripcion, total, id_cliente) VALUES ('computacion', 7000, 2);