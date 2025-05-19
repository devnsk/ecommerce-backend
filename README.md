
# E-commerce

An E-commerce Spring Boot project is a web application that provides an online shopping platform using Spring Boot, a popular framework for Java-based applications. This project typically includes features such as user authentication, product catalog management, shopping cart functionality, order processing, and payment integration.


## **API Endpoints & Payloads**  

### **Product Category - Add**  
**POST** `/api/product-categories`  
**Payload:**
```json
{
  "categoryName": "Bikes"
}
```

### **Get All Product Categories**  
**GET** `/api/product-categories`  
**Sample Response:**
```json
[
  {
    "id": 1,
    "categoryName": "BOOKS",
    "products": [
      {
        "id": 5,
        "sku": "BOOK-TECH-1004",
        "name": "The Go Programming Language: A to Z",
        "description": "Learn Go",
        "unitPrice": 24.99,
        "imageUrl": "assets/images/products/placeholder.png",
        "active": true,
        "unitsInStock": 100,
        "dateCreated": "2025-05-16T20:23:16.964+00:00",
        "categoryId": 1
      },
      {
        "id": 1,
        "sku": "BOOK-TECH-1000",
        "name": "JavaScript - The Fun Parts",
        "description": "Learn JavaScript",
        "unitPrice": 19.99,
        "imageUrl": "assets/images/products/placeholder.png",
        "active": true,
        "unitsInStock": 100,
        "dateCreated": "2025-05-16T20:23:13.912+00:00",
        "categoryId": 1
      }
    ]
  }
]
```

### **Get Product Category by ID**  
**GET** `/api/product-categories/{id}`  
**Sample Response:**
```json
{
  "id": 2,
  "categoryName": "Cars",
  "products": []
}
```

### **Update Product Category**  
**PUT** `/api/product-categories/{id}`  
**Payload:**
```json
{
  "categoryName": "Bikes"
}
```
_(Use this to change only the category name.)_

### **Delete Product Category**  
**DELETE** `/api/product-categories/{id}`  
**Response:**  
**204 No Content**


### **Upload Image to Cloudinary**  
**POST** `/cloudinary/image`  

**Request Parameters (Form Data):**

| Name   | Type | Required | Description           |
|--------|------|----------|-----------------------|
| image  | File | Yes      | The image file to upload |

**Sample Response:**
```json
{
  "asset_id": "abc123",
  "public_id": "SpringProject/sample-image",
  "url": "http://res.cloudinary.com/your_cloud_name/image/upload/v1234567890/SpringProject/sample-image.jpg",
  "secure_url": "https://res.cloudinary.com/your_cloud_name/image/upload/v1234567890/SpringProject/sample-image.jpg",
  "folder": "SpringProject",
  "format": "jpg",
  "resource_type": "image",
  "created_at": "2025-05-18T10:00:00Z"
}
