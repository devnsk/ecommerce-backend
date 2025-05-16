# Ecommerce Database Setup Guide

This guide provides step-by-step instructions to set up the `ecommerce` database in PostgreSQL using pgAdmin. It includes creating the database, setting up tables in the `public` schema, and adding sample data.

## Prerequisites
- PostgreSQL installed and running (version 10 or later recommended).
- pgAdmin 4 installed.
- Superuser access to create databases (e.g., log in as the `postgres` user).

## Step 1: Create the `ecommerce` Database in pgAdmin
1. Open pgAdmin.
2. In the left-hand panel, expand your PostgreSQL server (e.g., "PostgreSQL 16").
3. Right-click on "Databases" and select **Create** > **Database**.
4. In the dialog:
    - **Name**: `ecommerce`
    - **Owner**: Leave as default (e.g., `postgres`) or select a user with appropriate privileges.
    - Click **Save**.
5. The `ecommerce` database should now appear under "Databases".

## Step 2: Create Tables and Insert Sample Data
Use the following SQL script to create the `product_category` and `product` tables in the `public` schema of the `ecommerce` database, and insert sample data.

```sql
-- Connect to the ecommerce database
SET search_path TO public;

-- Drop tables if they exist
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS product_category CASCADE;

-- Create table product_category
CREATE TABLE product_category (
    id BIGSERIAL PRIMARY KEY,
    category_name VARCHAR(255)
);

-- Create table product
CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    sku VARCHAR(255),
    name VARCHAR(255),
    description VARCHAR(255),
    unit_price NUMERIC(13,2),
    image_url VARCHAR(255),
    active BOOLEAN DEFAULT TRUE,
    units_in_stock INTEGER,
    date_created TIMESTAMP,
    last_updated TIMESTAMP,
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES product_category (id)
);

-- Create index for foreign key
CREATE INDEX idx_fk_category ON product (category_id);

-- Add sample data
INSERT INTO product_category (category_name) VALUES ('BOOKS');

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1000', 'JavaScript - The Fun Parts', 'Learn JavaScript', 'assets/images/products/placeholder.png', TRUE, 100, 19.99, 1, CURRENT_TIMESTAMP);

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1001', 'Spring Framework Tutorial', 'Learn Spring', 'assets/images/products/placeholder.png', TRUE, 100, 29.99, 1, CURRENT_TIMESTAMP);

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1002', 'Kubernetes - Deploying Containers', 'Learn Kubernetes', 'assets/images/products/placeholder.png', TRUE, 100, 24.99, 1, CURRENT_TIMESTAMP);

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1003', 'Internet of Things (IoT) - Getting Started', 'Learn IoT', 'assets/images/products/placeholder.png', TRUE, 100, 29.99, 1, CURRENT_TIMESTAMP);

INSERT INTO product (sku, name, description, image_url, active, units_in_stock, unit_price, category_id, date_created)
VALUES ('BOOK-TECH-1004', 'The Go Programming Language: A to Z', 'Learn Go', 'assets/images/products/placeholder.png', TRUE, 100, 24.99, 1, CURRENT_TIMESTAMP);
```

## Step 3: Execute the Script in pgAdmin
1. In pgAdmin, expand the `ecommerce` database in the left panel.
2. Right-click on the `ecommerce` database and select **Query Tool**.
3. Copy and paste the SQL script above into the Query Tool.
4. Click the **Execute/Run** button (or press `F5`).
5. Check the "Data Output" tab below for any errors.

## Step 4: Verify the Tables
1. In the left panel, expand `ecommerce` > `Schemas` > `public` > `Tables`.
2. You should see `product` and `product_category`.
3. Right-click each table, select **View/Edit Data** > **All Rows** to confirm the sample data (e.g., "BOOKS" in `product_category` and the book entries in `product`).

