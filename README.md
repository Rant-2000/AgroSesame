# AgroSesame - Gestión de Jornaleros de Ajonjolí

## Descripción del Proyecto

AgroSesame es un sistema diseñado para registrar y gestionar los montos por jornalero (socio) en las temporadas de cosecha de ajonjolí. Este sistema permite llevar un control eficiente de los socios, temporadas, terrenos, cortes, facturas y préstamos, facilitando así la administración y seguimiento de los recursos agrícolas.

## Estructura de la Base de Datos

El proyecto utiliza MySQL 8 y consta de las siguientes tablas:

### 1. Socios

| Campo     | Tipo   | Descripción                       |
|-----------|--------|-----------------------------------|
| id        | BIGINT | Identificador único del socio      |
| nombre    | TEXT   | Nombre del socio                   |
| direccion | TEXT   | Dirección del socio                |
| telefono  | TEXT   | Número de teléfono del socio       |

### 2. Temporadas

| Campo  | Tipo   | Descripción                                      |
|--------|--------|--------------------------------------------------|
| id     | BIGINT | Identificador único de la temporada               |
| nombre | TEXT   | Nombre de la temporada                            |
| inicio | DATE   | Fecha de inicio de la temporada                  |
| fin    | DATE   | Fecha de finalización de la temporada            |

### 3. Terrenos

| Campo      | Tipo     | Descripción                                     |
|------------|----------|-------------------------------------------------|
| id         | BIGINT   | Identificador único del terreno                  |
| socio_id   | BIGINT   | Referencia al socio propietario                  |
| area       | DECIMAL  | Área del terreno en hectáreas                   |
| es_de_riego | BOOLEAN | Indica si el terreno es de riego (true/false)  |
| coordenadas| TEXT     | Coordenadas del terreno en Google Maps          |

### 4. Cortes

| Campo        | Tipo     | Descripción                                    |
|--------------|----------|------------------------------------------------|
| id           | BIGINT   | Identificador único del corte                   |
| socio_id     | BIGINT   | Referencia al socio que realizó el corte       |
| temporada_id  | BIGINT   | Referencia a la temporada correspondiente        |
| kilos        | DECIMAL  | Cantidad de kilos cosechados                   |

### 5. Facturas

| Campo     | Tipo     | Descripción                                    |
|-----------|----------|------------------------------------------------|
| id        | BIGINT   | Identificador único de la factura               |
| socio_id  | BIGINT   | Referencia al socio a quien se emite la factura|
| fecha     | DATE     | Fecha de emisión de la factura                 |
| monto     | DECIMAL  | Monto total de la factura                       |

### 6. Préstamos

| Campo     | Tipo     | Descripción                                    |
|-----------|----------|------------------------------------------------|
| id        | BIGINT   | Identificador único del préstamo                 |
| socio_id  | BIGINT   | Referencia al socio que recibe el préstamo     |
| fecha     | DATE     | Fecha en que se otorgó el préstamo             |
| monto     | DECIMAL  | Monto del préstamo                              |
| pagado    | BOOLEAN  | Indica si el préstamo ha sido pagado (true/false)|

## Tecnologías Utilizadas

- **Spring Boot**: Para el desarrollo del backend.
- **JPA**: Para la gestión de la persistencia de datos.
- **MySQL 8**: Como base de datos para el almacenamiento de información.

## Cómo Comenzar

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/agrosesame.git
   cd agrosesame
