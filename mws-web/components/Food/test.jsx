'use client';

import { useState, useEffect } from 'react';
import supabase from '@/lib/supabase-browser';

export default function Food() {
  const [foodName, setFoodName] = useState('null');
  const [foodDesc, setFoodDesc] = useState('null');

  async function fetchFood() {
    const { data, error } = await supabase
      .from('item_types')
      .select('*')
      .eq('id', 'edb394f9-9fbb-496e-b9a7-1895ae23ac86')
      .single();

    if (error) {
      console.error('Error fetching user data:', error);
    } else {
      setFoodName(data.name);
      setFoodDesc(data.description);
    }
  }

  useEffect(() => {
    fetchFood();
  });

  return (
    <div>
      <div>
        {foodName}
        <br></br>
        {foodDesc}
      </div>
      <div></div>
    </div>
  );
}
