'use client';

import React from 'react'
import { useState, useEffect } from 'react';
import supabase from '@/lib/supabase-browser';
import { useAuth } from '@/components/AuthProvider';

export default function page({ params }) {
    const [itemName, setItemName] = useState('null');
    const [itemDesc, setItemDesc] = useState('null');


  
    async function fetchItem() {
      const { data, error } = await supabase
        .from('item_types')
        .select('*')
        .eq('id', params.id)
        .single();
  
      if (error) {
        console.error('Error fetching user data:', error);
      } else {
        setItemName(data.name);
        setItemDesc(data.description);
      }
    }
  
    useEffect(() => {
      fetchItem();
    });
  
    return (
      <div>
        <div>
          { itemName }
          <br />
          { itemDesc }
        </div>
        <div></div>
      </div>
    );
  }
  
