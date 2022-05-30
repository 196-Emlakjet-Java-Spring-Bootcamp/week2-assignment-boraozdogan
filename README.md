
## API Endpoints

| API Endpoint               | Description                                   |
|----------------------------|-----------------------------------------------|
| `GET /posts`               | List all posts                                |
| `GET /posts/latest`        | List latest 3 posts (sorted by creation date) |
| `GET /posts/{id}`          | Show a specific post                          |
| `GET /posts/of/{author}`   | List all posts from an author                 |
| `GET /posts/in/{category}` | List all posts belongs to a category          |
| `POST /posts`              | Create a post                                 |
| `PUT /posts/{id}`          | Modify a post                                 |


<!--
## Requirements, sort of..

1- CRUD Web Service (h2 veritabani)
     - Create 
     - Update 
     - Delete 
     - Search 
Model
   - Post
      - Author 
      - Title 
      - CreatedAt 
      - UpdatedAt
      - UpdatedBy 
      - Text 
      - Category ["category1", 'category2']



      
- createdBy
Servisler : 
- getPost(id)
-createPost


- updatePost(postbilgileri, username)
- findPostByAuthor()
findPostByCategory(categoryName)


- getLatestPost() en son 3 postu getirsin 

H2 database

-->