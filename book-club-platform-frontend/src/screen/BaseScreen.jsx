import Navbar from '@/feature/Navbar'
import React from 'react'
import { Outlet } from 'react-router'

const BaseScreen = () => {
  return (
    <div>
        <Navbar/>
        <div className='container mx-auto px-4 max-w-7xl'>
        <Outlet/>
        </div>
    </div>
  )
}

export default BaseScreen