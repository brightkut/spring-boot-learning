BEGIN;
INSERT INTO person (first_name, last_name, age)
SELECT 'First' || generate_series, 'Last' || generate_series, (random() * 80 + 20)::INT
FROM generate_series(1, 5000000);
COMMIT;
