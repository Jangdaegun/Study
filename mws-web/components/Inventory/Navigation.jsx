'use client';
import { useState } from 'react';
import { FaBars, FaTimes } from 'react-icons/fa';
import { IoBusinessSharp } from 'react-icons/io5';

const Navigation = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div>
      <div className="md:hidden bg-gray-800">
        <div className="flex items-center justify-between h-16 px-4">
          <button
            onClick={toggleMenu}
            className="bg-gray-800 inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none"
          >
            <span className="sr-only">Open main menu</span>
            {isOpen ? <FaTimes /> : <FaBars />}
          </button>
          <div className="text-white text-xl font-semibold">Inventory</div>
          <div className="w-8" /> {/* Spacer to keep the layout aligned */}
        </div>
        {isOpen && (
          <div className="absolute bg-gray-800 w-full z-50 px-2 pt-2 pb-3 space-y-1">
          <a href="/business-manager/business" className="text-white block px-3 py-2 rounded-md text-base font-medium">
              Business
            </a>
            <a href="/business-manager/item-types" className="text-white block px-3 py-2 rounded-md text-base font-medium">
            Item Types
            </a>
          </div>
        )}
      </div>
      
      <div className="fixed hidden md:block bg-gray-800 h-screen w-56">
        <div className="flex flex-col items-start h-16 px-4 py-2">
          <div className="flex items-center space-x-2">
            <IoBusinessSharp className="text-white" />
            <div className="text-white text-xl font-semibold">Inventory</div>
          </div>
        </div>
        <div className="flex flex-col space-y-4 px-4 py-2">
          <a href="business-admin/menu1" className="text-gray-300 hover:text-white px-3 py-2 rounded-md text-sm font-medium">
            Menu 1
          </a>
          <a href="business-admin/menu2" className="text-gray-300 hover:text-white px-3 py-2 rounded-md text-sm font-medium">
            Menu 2
          </a>
        </div>
      </div>
    </div>
  );
};

export default Navigation;
