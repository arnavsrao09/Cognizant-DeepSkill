import React from "react";

function CourseDetails() {

  const courses = [
    {
      id: 1,
      name: "React",
      date: "10-07-2026"
    },
    {
      id: 2,
      name: "Angular",
      date: "15-07-2026"
    },
    {
      id: 3,
      name: "NodeJS",
      date: "20-07-2026"
    }
  ];

  return (
    <div>
      <h2>Course Details</h2>

      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            {course.name} - {course.date}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;