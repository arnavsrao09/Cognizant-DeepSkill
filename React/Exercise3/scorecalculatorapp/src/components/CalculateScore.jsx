import React from 'react'
import '../mystyle.css'
const percentToDecimal = (percent) => {
    return (percent.toFixed(2)+'%')
}

const calcScore = (total, goal) => {
    return percentToDecimal(total/goal) 
}

const CalculateScore = ({Name,School, total, goal}) => {
  return (
    <div className="formatStyle">
        <h1><font color='brown'>Student Details:</font></h1>
        <div className='Name'>
            <b><span>Name: </span></b>
            <span>{Name}</span>
        </div>
        <div className='School'>
            <b><span>School: </span></b>
            <span>{School}</span>
        </div>
        <div className='Total'>
            <b><span>Total Score: </span></b>
            <span>{total}</span>
            <span>marks</span>
        </div>
        <div className='Score'>
            <b>Score: </b>
            <span>{calcScore(total,goal)}</span>
        </div>
    </div>
  )
}

export default CalculateScore