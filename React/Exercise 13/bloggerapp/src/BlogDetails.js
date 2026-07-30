import React from "react";

function BlogDetails() {

  const blogs = [
    {
      id: 1,
      title: "React Learning",
      author: "Scott"
    },
    {
      id: 2,
      title: "Installation",
      author: "Sneha"
    }
  ];

  return (
    <div>
      <h2>Blog Details</h2>

      {blogs.map((blog) => (
        <div
          key={blog.id}
          style={{
            border: "1px solid black",
            padding: "10px",
            marginBottom: "10px"
          }}
        >
          <h3>{blog.title}</h3>
          <p>Author : {blog.author}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;