# Timeline API

AI-powered news platform that generates timelines automatically using artificial intelligence and n8n workflow automation.

## How to run

### 1. Build the application
```bash
mvn clean install -DskipTests
```

### 2. Start the project
```bash
docker compose up --build -d
```

Done! The application will be running with PostgreSQL configured.

## Database

PostgreSQL must be created with the tables:

- **timeline** - Main timelines
- **timeline_event** - Events for each timeline  
- **timeline_event_source** - Event sources/links

```sql
-- Table Timeline
CREATE TABLE timeline.timeline.timeline (
    id_timeline BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    dh_created TIMESTAMP,
    dh_updated TIMESTAMP
);

-- Table Timeline Event
CREATE TABLE timeline.timeline_event (
    id_timeline_event BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    resume VARCHAR(700),
    id_timeline BIGINT NOT NULL,
    dt_event DATE,
    dh_created TIMESTAMP,
    dh_updated TIMESTAMP,
    CONSTRAINT fk_timeline FOREIGN KEY (id_timeline) REFERENCES timeline.timeline (id_timeline) ON DELETE CASCADE
);

-- Table Timeline Event Source
CREATE TABLE timeline.timeline_event_source (
    id_timeline_event_source BIGSERIAL PRIMARY KEY,
    link VARCHAR(255),
    id_timeline_event BIGINT NOT NULL,
    CONSTRAINT fk_timeline_event FOREIGN KEY (id_timeline_event) REFERENCES timeline.timeline_event (id_timeline_event) ON DELETE CASCADE
);
```

## Requirements

- Java 21+
- Maven
- Docker
