
# Schulhaus-CRM

Mit dieser Applikation kann man mehrere Schulhäuser verwalten. 
In dieser Applikation gibt es Schulhäuser, Klassenlehrpersonen, Klassen und Schüler. 
Als Admin kann man Klassen, Schüler und Klassenlehrpersonen erstellen, löschen und anzeigen. 
Als Lehrer kann man nur das Schulhaus, die Klassen, die Lehrer und die Schüler. 
Als Schüler kann man nur die Klasse und die Schüler anzeigen. 
Die Applikation kann über eine Webseite oder über ein REST-Interface zugegriffen werden.
Wenn auf die Applikation über das Web zugriffen wird, hat es ein GUI/ Webseite.





## Applikation starten

Das Projekt klonen

```bash
  git clone https://github.com/MaloJaboulet/Schulhaus_CRM
```

Das Projekt mit Eclipse oder mit Intellij öffnen

Das Datei "CrmApplikation" anklicken und starten

Danach auf den Port 8080 gehen


## API Referenzen

#### Get alle Klassen

```http
  GET /api/v1/klassen
```


#### Get eine Klasse

```http
  GET /api/v1/klassen/{id}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long`   | **Required**. Id der Klasse       |

#### Eine Klasse erstellen

```http
  POST /api/v1/klassen/
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `klassenData`| `KlassenInputDTO`   | **Required**. Die Klasse.       |

#### Delete eine Klasse

```http
  Delete /api/v1/klassen/{name}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `name`| `String`   | **Required**. Der Name der Klasse       |


#### Get Schüler einer Klasse

```http
  GET /api/v1/klassen/{id}/schueler
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `id`| `Long`   | **Required**. Die ID der Klasse      |

#### Schüler einer Klasse hinzufügen

```http
  POST /api/v1/klassen/{id}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `id`| `Long`   | **Required**. Die ID der Klasse      |
| `schuelerData`| `SchuelerInputDTO`   | **Required**. Das Schülerobjekt|

#### GET alle Schüler

```http
  GET /api/v1/schueler
```

#### GET ein Schüler

```http
  GET /api/v1/schueler/{id}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `id`| `Long`   | **Required**. Die ID des Schüler     |

#### Schüler erstellen

```http
  POST /api/v1/schueler/
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `schuelerData`| `SchuelerInputDTO`   | **Required**. Das Schülerobjekt     |

#### Schüler löschen

```http
  Delete /api/v1/schueler/{vorname}/{nachname}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `vorname`| `String`   | **Required**. Der Vorname des Schülers    |
| `nachname`| `String`   | **Required**. Der Nachname des Schülers    |

#### Schüler bearbeiten

```http
  POST /api/v1/schueler/{id}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `id`| `Long`   | **Required**. Die ID des Schülers    |
| `schuelerInputDTO`| `SchuelerInputDTO`   | **Required**. Das Schülerobjekt    |

#### GET Schulhaus

```http
  GET /api/v1/schulhaus/{id}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `id`| `Long`   | **Required**. Die ID des Schulhauses    |

#### Schulhaus erstellen

```http
  POST /api/v1/schulhaus
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `schulhausInputDTO`| `SchulhausInputDTO`   | **Required**. Das Schulhausobjekt   |

#### Schulhaus löschen

```http
  DELETE /api/v1/schulhaus/{name}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `name`| `String`   | **Required**. Der Name des Schulhauses   |

#### GET Klassenlehrperson

```http
  GET /api/v1/klassenlehrperson/{id}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `id`| `Long`   | **Required**. Die ID der Klassenlehrperson  |

#### Klassenlehrperson erstellen

```http
  POST /api/v1/klassenlehrperson
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `klassenlehrpersonInputDTO`| `KlassenlehrpersonInputDTO`   | **Required**. Das Klassenlehrperson-Objekt  |


#### Klassenlehrperson löschen

```http
  DELETE /api/v1/klassenlehrperson/{vorname}/{nachname}
```

| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `vorname`| `String`   | **Required**. Der Vorname der Klassenlehrperson  |
| `nachname`| `String`   | **Required**. Der Nachname der Klassenlehrperson  |

#### Webseite mit allen Schülern

```http
  GET /schueler
```

#### Webseite um einen Schüler zu bearbeiten

```http
  GET /schuelerEdit
```

#### Webseite um einen Schüler zu bearbeiten

```http
  POST /schueler
```
| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `vorname`| `String`   | **Required**. Der Vorname der Schülers  |
| `nachname`| `String`   | **Required**. Der Nachname der Schülers  |
| `klassenName`| `String`   | **Required**. Der Nachname der Klasse  |
| `password`| `String`   | **Required**. Password des Schülers  |

#### Webseite für das Löschen eines Schülers

```http
  GET /schuelerDelete/{vorname}/{nachname}
```
| Parameter | Type     | Beschreibung                      |
| :-------- | :------- | :-------------------------------- |
| `vorname`| `String`   | **Required**. Der Vorname der Schülers  |
| `nachname`| `String`   | **Required**. Der Nachname der Schülers  |


