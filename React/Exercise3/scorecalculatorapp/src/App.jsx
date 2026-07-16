import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import CalculateScore from './components/CalculateScore'

function App() {

  return (
    <>
      <CalculateScore 
      Name="Arnav"
      School="St. Xavier's"
      total={284}
      goal={3}
      />
    </>
  )
}

export default App
