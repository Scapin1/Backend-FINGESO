-- Tabla medico
INSERT INTO medico (id, rut, nombre, rol, correo, password, especialidad) VALUES
                                                                              (1, '10.000.001-1', 'Dr. Juan Pérez', 'MEDICO', 'juan.perez@umbrella.cl', 'pass1', 'Cardiología'),
                                                                              (2, '10.000.002-2', 'Dra. Ana López', 'MEDICO', 'ana.lopez@umbrella.cl', 'pass2', 'Pediatría'),
                                                                              (3, '10.000.003-3', 'Dr. Luis Soto', 'MEDICO', 'luis.soto@umbrella.cl', 'pass3', 'Dermatología'),
                                                                              (4, '10.000.004-4', 'Dra. Marta Ruiz', 'MEDICO', 'marta.ruiz@umbrella.cl', 'pass4', 'Neurología'),
                                                                              (5, '10.000.005-5', 'Dr. Pablo Díaz', 'MEDICO', 'pablo.diaz@umbrella.cl', 'pass5', 'Traumatología'),
                                                                              (6, '10.000.006-6', 'Dr. Sergio Vidal', 'MEDICO', 'sergio.vidal@umbrella.cl', 'pass6', 'Ginecología'),
                                                                              (7, '10.000.007-7', 'Dra. Camila Ríos', 'MEDICO', 'camila.rios@umbrella.cl', 'pass7', 'Oftalmología'),
                                                                              (8, '10.000.008-8', 'Dr. Tomás Herrera', 'MEDICO', 'tomas.herrera@umbrella.cl', 'pass8', 'Psiquiatría'),
                                                                              (9, '10.000.009-9', 'Dra. Valentina Silva', 'MEDICO', 'valentina.silva@umbrella.cl', 'pass9', 'Oncología'),
                                                                              (10, '10.000.010-0', 'Dr. Ignacio Pino', 'MEDICO', 'ignacio.pino@umbrella.cl', 'pass10', 'Urología');

-- Tabla paciente
INSERT INTO paciente (id, rut, nombre, rol, correo, password, fecha_nacimiento) VALUES
                                                                                    (11, '20.000.001-1', 'Carlos Gómez', 'PACIENTE', 'carlos.gomez@correo.com', 'pass1', '1990-05-10'),
                                                                                    (12, '20.000.002-2', 'María Torres', 'PACIENTE', 'maria.torres@correo.com', 'pass2', '1985-08-22'),
                                                                                    (13, '20.000.003-3', 'Pedro Ramírez', 'PACIENTE', 'pedro.ramirez@correo.com', 'pass3', '2000-01-15'),
                                                                                    (14, '20.000.004-4', 'Lucía Fernández', 'PACIENTE', 'lucia.fernandez@correo.com', 'pass4', '1995-12-30'),
                                                                                    (15, '20.000.005-5', 'Javier Castro', 'PACIENTE', 'javier.castro@correo.com', 'pass5', '1988-03-05'),
                                                                                    (16, '20.000.006-6', 'Andrea Salas', 'PACIENTE', 'andrea.salas@correo.com', 'pass6', '1992-07-19'),
                                                                                    (17, '20.000.007-7', 'Rodrigo León', 'PACIENTE', 'rodrigo.leon@correo.com', 'pass7', '1983-11-23'),
                                                                                    (18, '20.000.008-8', 'Patricia Mora', 'PACIENTE', 'patricia.mora@correo.com', 'pass8', '1997-09-14'),
                                                                                    (19, '20.000.009-9', 'Sofía Navarro', 'PACIENTE', 'sofia.navarro@correo.com', 'pass9', '2001-02-28'),
                                                                                    (20, '20.000.010-0', 'Matías Herrera', 'PACIENTE', 'matias.herrera@correo.com', 'pass10', '1994-06-17');

-- Tabla enfermero
INSERT INTO enfermero (id, rut, nombre, rol, correo, password) VALUES
                                                                   (21, '30.000.001-1', 'Tomás Silva', 'ENFERMERO', 'tomas.silva@umbrella.cl', 'pass1'),
                                                                   (22, '30.000.002-2', 'Paula Rojas', 'ENFERMERO', 'paula.rojas@umbrella.cl', 'pass2'),
                                                                   (23, '30.000.003-3', 'Diego Vera', 'ENFERMERO', 'diego.vera@umbrella.cl', 'pass3'),
                                                                   (24, '30.000.004-4', 'Camila Soto', 'ENFERMERO', 'camila.soto@umbrella.cl', 'pass4'),
                                                                   (25, '30.000.005-5', 'Felipe Reyes', 'ENFERMERO', 'felipe.reyes@umbrella.cl', 'pass5'),
                                                                   (26, '30.000.006-6', 'Francisca Vidal', 'ENFERMERO', 'francisca.vidal@umbrella.cl', 'pass6'),
                                                                   (27, '30.000.007-7', 'Jorge Fuentes', 'ENFERMERO', 'jorge.fuentes@umbrella.cl', 'pass7'),
                                                                   (28, '30.000.008-8', 'Valentina Silva', 'ENFERMERO', 'valentina.silva@umbrella.cl', 'pass8'),
                                                                   (29, '30.000.009-9', 'Pablo Rivas', 'ENFERMERO', 'pablo.rivas@umbrella.cl', 'pass9'),
                                                                   (30, '30.000.010-0', 'Fernanda Díaz', 'ENFERMERO', 'fernanda.diaz@umbrella.cl', 'pass10');

-- Tabla gerente
INSERT INTO gerente (id, rut, nombre, rol, correo, password) VALUES
                                                                 (31, '40.000.001-1', 'Laura Méndez', 'GERENTE', 'laura.mendez@umbrella.cl', 'pass1'),
                                                                 (32, '40.000.002-2', 'Sergio Paredes', 'GERENTE', 'sergio.paredes@umbrella.cl', 'pass2'),
                                                                 (33, '40.000.003-3', 'Andrea Salas', 'GERENTE', 'andrea.salas@umbrella.cl', 'pass3'),
                                                                 (34, '40.000.004-4', 'Rodrigo León', 'GERENTE', 'rodrigo.leon@umbrella.cl', 'pass4'),
                                                                 (35, '40.000.005-5', 'Patricia Mora', 'GERENTE', 'patricia.mora@umbrella.cl', 'pass5'),
                                                                 (36, '40.000.006-6', 'Sofía Navarro', 'GERENTE', 'sofia.navarro@umbrella.cl', 'pass6'),
                                                                 (37, '40.000.007-7', 'Matías Herrera', 'GERENTE', 'matias.herrera@umbrella.cl', 'pass7'),
                                                                 (38, '40.000.008-8', 'Daniela Peña', 'GERENTE', 'daniela.pena@umbrella.cl', 'pass8'),
                                                                 (39, '40.000.009-9', 'Nicolás Bravo', 'GERENTE', 'nicolas.bravo@umbrella.cl', 'pass9'),
                                                                 (40, '40.000.010-0', 'Francisca Vidal', 'GERENTE', 'francisca.vidal@umbrella.cl', 'pass10');

-- Tabla quimicofarmaceutico
INSERT INTO quimico_farmaceutico (id, rut, nombre, rol, correo, password) VALUES
                                                                              (41, '50.000.001-1', 'Sofía Navarro', 'QUIMICOFARMACEUTICO', 'sofia.navarro@umbrella.cl', 'pass1'),
                                                                              (42, '50.000.002-2', 'Matías Herrera', 'QUIMICOFARMACEUTICO', 'matias.herrera@umbrella.cl', 'pass2'),
                                                                              (43, '50.000.003-3', 'Daniela Peña', 'QUIMICOFARMACEUTICO', 'daniela.pena@umbrella.cl', 'pass3'),
                                                                              (44, '50.000.004-4', 'Nicolás Bravo', 'QUIMICOFARMACEUTICO', 'nicolas.bravo@umbrella.cl', 'pass4'),
                                                                              (45, '50.000.005-5', 'Francisca Vidal', 'QUIMICOFARMACEUTICO', 'francisca.vidal@umbrella.cl', 'pass5'),
                                                                              (46, '50.000.006-6', 'Jorge Fuentes', 'QUIMICOFARMACEUTICO', 'jorge.fuentes@umbrella.cl', 'pass6'),
                                                                              (47, '50.000.007-7', 'Valentina Silva', 'QUIMICOFARMACEUTICO', 'valentina.silva@umbrella.cl', 'pass7'),
                                                                              (48, '50.000.008-8', 'Pablo Rivas', 'QUIMICOFARMACEUTICO', 'pablo.rivas@umbrella.cl', 'pass8'),
                                                                              (49, '50.000.009-9', 'Fernanda Díaz', 'QUIMICOFARMACEUTICO', 'fernanda.diaz@umbrella.cl', 'pass9'),
                                                                              (50, '50.000.010-0', 'Tomás Campos', 'QUIMICOFARMACEUTICO', 'tomas.campos@umbrella.cl', 'pass10');

-- Tabla secretario
INSERT INTO secretario (id, rut, nombre, rol, correo, password) VALUES
                                                                    (51, '60.000.001-1', 'Jorge Fuentes', 'SECRETARIO', 'jorge.fuentes@umbrella.cl', 'pass1'),
                                                                    (52, '60.000.002-2', 'Valentina Silva', 'SECRETARIO', 'valentina.silva@umbrella.cl', 'pass2'),
                                                                    (53, '60.000.003-3', 'Pablo Rivas', 'SECRETARIO', 'pablo.rivas@umbrella.cl', 'pass3'),
                                                                    (54, '60.000.004-4', 'Fernanda Díaz', 'SECRETARIO', 'fernanda.diaz@umbrella.cl', 'pass4'),
                                                                    (55, '60.000.005-5', 'Tomás Campos', 'SECRETARIO', 'tomas.campos@umbrella.cl', 'pass5'),
                                                                    (56, '60.000.006-6', 'Camila Soto', 'SECRETARIO', 'camila.soto@umbrella.cl', 'pass6'),
                                                                    (57, '60.000.007-7', 'Felipe Reyes', 'SECRETARIO', 'felipe.reyes@umbrella.cl', 'pass7'),
                                                                    (58, '60.000.008-8', 'Francisca Vidal', 'SECRETARIO', 'francisca.vidal@umbrella.cl', 'pass8'),
                                                                    (59, '60.000.009-9', 'Ignacio Pino', 'SECRETARIO', 'ignacio.pino@umbrella.cl', 'pass9'),
                                                                    (60, '60.000.010-0', 'Carla Muñoz', 'SECRETARIO', 'carla.munoz@umbrella.cl', 'pass10');

-- Tabla soportetecnico
INSERT INTO soporte_tecnico (id, rut, nombre, rol, correo, password) VALUES
                                                                         (61, '70.000.001-1', 'Admin', 'SOPORTETECNICO', 'admin@umbrella.cl', 'admin123'),
                                                                         (62, '70.000.002-2', 'Carla Muñoz', 'SOPORTETECNICO', 'carla.munoz@umbrella.cl', 'pass2'),
                                                                         (63, '70.000.003-3', 'Felipe Soto', 'SOPORTETECNICO', 'felipe.soto@umbrella.cl', 'pass3'),
                                                                         (64, '70.000.004-4', 'Antonia Reyes', 'SOPORTETECNICO', 'antonia.reyes@umbrella.cl', 'pass4'),
                                                                         (65, '70.000.005-5', 'Ignacio Pino', 'SOPORTETECNICO', 'ignacio.pino@umbrella.cl', 'pass5'),
                                                                         (66, '70.000.006-6', 'Tomás Silva', 'SOPORTETECNICO', 'tomas.silva@umbrella.cl', 'pass6'),
                                                                         (67, '70.000.007-7', 'Paula Rojas', 'SOPORTETECNICO', 'paula.rojas@umbrella.cl', 'pass7'),
                                                                         (68, '70.000.008-8', 'Diego Vera', 'SOPORTETECNICO', 'diego.vera@umbrella.cl', 'pass8'),
                                                                         (69, '70.000.009-9', 'Camila Soto', 'SOPORTETECNICO', 'camila.soto@umbrella.cl', 'pass9'),
                                                                         (70, '70.000.010-0', 'Felipe Reyes', 'SOPORTETECNICO', 'felipe.reyes@umbrella.cl', 'pass10');
-- Insertar Medicamentos
INSERT INTO medicamento (id_medicamento, nombre_comercial, stock_real, stock_receta, descripcion, tipo_medicamento, principio_activo, gramage_ml, laboratorio) VALUES
                                                                                                                                                       (1, 'Paracetamol', 15, 0, 'Sirve para el tratamiento de fiebre y dolor leve a moderado.', 'Analgésico', 'Acetaminofén', '500mg', 'Bayer'),
                                                                                                                                                       (2, 'Ibuprofeno', 20, 0, 'AINE para reducir la fiebre, el dolor y la inflamación.', 'AINE', 'Ibuprofeno', '400mg', 'Grünenthal'),
                                                                                                                                                       (3, 'Amoxicilina', 30, 0, 'Antibiótico de amplio espectro para infecciones bacterianas.', 'Antibiótico', 'Amoxicilina', '250mg/5ml', 'Saval'),
                                                                                                                                                       (4, 'Loratadina', 0, 0, 'Antihistamínico para aliviar los síntomas de alergias.', 'Antihistamínico', 'Loratadina', '10mg', 'Andrómaco'),
                                                                                                                                                       (5, 'Omeprazol', 10, 0, 'Reduce la producción de ácido en el estómago.', 'Inhibidor de la bomba de protones', 'Omeprazol', '20mg', 'Bagó'),
                                                                                                                                                       (6, 'Aspirina', 18, 0, 'Analgésico, antipirético y antiinflamatorio.', 'AINE', 'Ácido acetilsalicílico', '500mg', 'Bayer'),
                                                                                                                                                       (7, 'Metformina', 25, 0, 'Controla el nivel de azúcar en la sangre.', 'Antidiabético', 'Metformina', '850mg', 'Lab. Chile'),
                                                                                                                                                       (8, 'Salbutamol', 12, 0, 'Broncodilatador para asma y enfermedades pulmonares.', 'Broncodilatador', 'Salbutamol', '100mcg/dosis', 'GSK'),
                                                                                                                                                       (9, 'Clorfenamina', 20, 0, 'Antihistamínico para alergias y resfriados.', 'Antihistamínico', 'Clorfenamina', '4mg', 'Recalcine'),
                                                                                                                                                       (10, 'Prednisona', 18, 0, 'Corticosteroide para inflamaciones y autoinmunidad.', 'Corticosteroide', 'Prednisona', '5mg', 'Saval'),
                                                                                                                                                       (11, 'Ranitidina', 15, 0, 'Reduce la producción de ácido gástrico.', 'Antiácido', 'Ranitidina', '150mg', 'Pfizer'),
                                                                                                                                                       (12, 'Ketorolaco', 10, 0, 'Potente analgésico para dolor moderado a severo.', 'AINE', 'Ketorolaco', '10mg', 'Roemmers'),
                                                                                                                                                       (13, 'Diclofenaco', 16, 0, 'Alivia inflamación y dolor muscular.', 'AINE', 'Diclofenaco', '50mg', 'Grünenthal'),
                                                                                                                                                       (14, 'Ciprofloxacino', 22, 0, 'Para infecciones urinarias y respiratorias.', 'Antibiótico', 'Ciprofloxacino', '500mg', 'Biosano'),
                                                                                                                                                       (15, 'Fexofenadina', 19, 0, 'Antihistamínico no sedante.', 'Antihistamínico', 'Fexofenadina', '120mg', 'Sanofi'),
                                                                                                                                                       (16, 'Naproxeno', 14, 0, 'Para artritis, dolor de cabeza y dismenorrea.', 'AINE', 'Naproxeno', '250mg', 'Recalcine'),
                                                                                                                                                       (17, 'Azitromicina', 26, 0, 'Antibiótico para infecciones respiratorias.', 'Antibiótico', 'Azitromicina', '500mg', 'Lab. Chile'),
                                                                                                                                                       (18, 'Levocetirizina', 10, 0, 'Para rinitis alérgica y urticaria crónica.', 'Antihistamínico', 'Levocetirizina', '5mg', 'Teva'),
                                                                                                                                                       (19, 'Tramadol', 12, 0, 'Opioide para dolor moderado a severo.', 'Analgésico', 'Tramadol', '100mg/2ml', 'Lab. Chile'),
                                                                                                                                                       (20, 'Amiodarona', 7, 0, 'Antiarrítmico para arritmias ventriculares.', 'Antiarrítmico', 'Amiodarona', '200mg', 'Saval'),
                                                                                                                                                       (21, 'Lamotrigina', 10, 0, 'Para convulsiones y bipolaridad.', 'Antiepiléptico', 'Lamotrigina', '25mg', 'Grünenthal'),
                                                                                                                                                       (22, 'Sertralina', 20, 0, 'ISRS para depresión y ansiedad.', 'Antidepresivo', 'Sertralina', '50mg', 'Pfizer'),
                                                                                                                                                       (23, 'Haloperidol', 8, 0, 'Antipsicótico típico.', 'Antipsicótico', 'Haloperidol', '5mg/ml', 'Roche'),
                                                                                                                                                       (24, 'Aciclovir', 15, 0, 'Antiviral contra herpes y zóster.', 'Antiviral', 'Aciclovir', '400mg', 'Andrómaco');

-- Insertar Sucursales
INSERT INTO sucursal (id_sucursal, nombre_sucursal, direccion) VALUES
                                                          (1, 'Sucursal Norte', '912 West Birkin Boulevard, Raccoon City, RC 50214'),
                                                          (2, 'Sucursal Centro', '300 Spencer Lane, Medical District, Raccoon City, RC 50211'),
                                                          (3, 'Sucursal Sur', '77 Cain Street, Central District, Raccoon City, RC 50209');