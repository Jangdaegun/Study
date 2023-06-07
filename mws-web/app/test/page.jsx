'use client';

import { useState, useEffect } from 'react';
import supabase from '@/lib/supabase-browser';
import { useAuth } from '@/components/AuthProvider';
import Link from 'next/link';

export default function Profile() {
  const [money, setMoney] = useState(0);
  const [name, setName] = useState(0);
  const [newMoney, setNewMoney] = useState(0);
  const [testUser, setTestUser] = useState("not fetched");
  const [items, setItems] = useState([]);

  const { user } = useAuth();


  useEffect(() => {
    if (user) {
      fetchUserData();
      fetchTestUser();
      fetchItems();
    
    }
  }, [user]);

  async function fetchItems() {
    const { data, error } = await supabase
      .from('item_types')
      .select('*')
  
    if (error) {
      console.error('Error fetching user data:', error);
    } else {
      setItems(data);
    }
  }

  async function fetchTestUser() {
    const { data, error } = await supabase
      .from('Food_test')
      .select('*')
      .eq('id', 1)
      .single();

    if (error) {
      console.error('Error fetching user data:', error);
    } else {
      setTestUser(data.name);
    }
  }



  async function fetchUserData() {

    const { data, error } = await supabase
      .from('profiles')
      .select('*')
      .eq('id', user.id)
      .single();

    if (error) {
      console.error('Error fetching user data:', error);
    } else {
      setMoney(data.money);
      setName(data.name)
    }
  }

  async function updateMoney() {
    const { error } = await supabase
      .from('profiles')
      .update({ money: newMoney })
      .eq('id', user.id);

    if (error) {
      console.error('Error updating money:', error);
    } else {
      setMoney(newMoney);
    }
  }

  return (
    <main>
      <div className="card">
        <h1>Test Page</h1>
        <p>Name: {name}</p>
        <p>Money: ${money}</p>
        {user && <p>Email: {user.email}</p>}
        <div>
          <input
            type="number"
            value={newMoney}
            onChange={(e) => setNewMoney(parseInt(e.target.value))}
            placeholder="Enter new money amount"
          />
          <button onClick={updateMoney}>Update Money</button>
        </div>
        <p>Test User: {testUser}</p>

        
        {items.map((item) => (
          <Link href={`/test/${item.id}`} key={item.id}>
            <h3 className="mt-2 font-semibold tracking-wide text-black group-hover:opacity-60">
              {item.name}
            </h3>
          </Link>
        ))}

      </div>

    </main>
  );
}

