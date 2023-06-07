'use client';
import { useState, useEffect, useRef } from 'react';
import Link from 'next/link';
import { useAuth } from '@/components/AuthProvider';
import supabase from '@/lib/supabase-browser';

export default function GlobalNav() {
    const [showControlPanel, setShowControlPanel] = useState(false);
    const [buttonImage, setButtonImage] = useState('logo0.svg');
    const timeoutRef = useRef([]);
    const { user, signOut } = useAuth();
    const [userName, setUserName] = useState(0);
    const [userMoney, setUserMoney] = useState(0);

    const handleButtonClick = () => {
        setShowControlPanel(!showControlPanel);
    };

    useEffect(() => {
        if (user) {
            fetchUserData();
        }
    }, [user]);

    async function fetchUserData() {

        const { data, error } = await supabase
            .from('profiles')
            .select('*')
            .eq('id', user.id)
            .single();

        if (error) {
            console.error('Error fetching user data:', error);
        } else {
            setUserName(data.name)
            setUserMoney(data.money)
        

        }
    }

    useEffect(() => {
        if (timeoutRef.current.length > 0) {
            timeoutRef.current.forEach(clearTimeout);
            timeoutRef.current = [];
        }

        for (let i = 0; i <= 3; i++) {
            const timeout = setTimeout(() => {
                if (!showControlPanel) {
                    setButtonImage(`logo${i}.svg`);
                } else {
                    setButtonImage(`logo${3 - i}.svg`);
                }
            }, (i * 1500) / 4);
            timeoutRef.current.push(timeout);
        }

        return () => {
            timeoutRef.current.forEach(clearTimeout);
            timeoutRef.current = [];
        };
    }, [showControlPanel]);


    return (
        <div className="fixed top-0 right-0 z-10">
            <div
                className={`bg-white transform transition-all duration-[1500ms] ease-in-out flex flex-col  rounded-bl-lg w-52 h-52 shadow-lg shadow-black/20
                                ${showControlPanel ? 'translate-x-0 translate-y-0' : 'translate-x-[10.5em] translate-y-[-10.5em]'}
                                `}
            >


                {user ? (
                    <>
                        <Link href="/profile">
                            <div className="mt-4 px-4 text-s font-semibold uppercase tracking-wider">
                                <h1>HI, {userName}</h1>
                                <p>${userMoney}</p>
                            </div>
                        </Link>
                        <div className="mt-4 px-4 text-xs font-semibold uppercase tracking-wider gap-1">
                            <Link
                                href="/"
                            >
                                <h3 className="mt-2 font-semibold tracking-wide text-black group-hover:opacity-60">
                                    Home
                                </h3>
                            </Link>
                            <Link
                                href="/inventory"
                            >
                                <h3 className="mt-2 font-semibold tracking-wide text-black group-hover:opacity-60">
                                    Inventory
                                </h3>
                            </Link>
                            <Link
                                href="/"
                            >
                                <h3 onClick={signOut} className="mt-2 font-semibold tracking-wide text-black group-hover:opacity-60">
                                    Sign Out
                                </h3>
                            </Link>
                        </div>
                    </>
                ) : (

                    <>
                        
                            <div className="mt-4 px-4 text-s font-semibold uppercase tracking-wider ">
                                <h1>Welcome!</h1>
                            </div>
                        
                        <div className="mt-4 px-4 text-xs font-semibold uppercase tracking-wider">
                            <Link href="/auth/signup">
                                <h3 className="mt-2 font-semibold tracking-wide text-black group-hover:opacity-60">
                                    Sign Up
                                </h3>
                            </Link>
                            <Link href="/auth/signin">
                                <h3 className="mt-2 font-semibold tracking-wide text-black group-hover:opacity-60">
                                    Sign In
                                </h3>
                            </Link>
                        </div>
                    </>
                )}



                <div className="flex-grow"></div>
                <Link
                    href="/"
                    className={`group flex ml-7 mb-2 w-full items-center transition-opacity duration-500 ${showControlPanel ? 'delay-[1400ms] opacity-100' : 'delay-[0ms] opacity-0'}`}
                >
                    <h3 className="font-semibold tracking-wide text-black group-hover:opacity-60">
                        Mini Web Simulator™
                    </h3>
                </Link>
                <button
                    className={`absolute bottom-0 left-0 w-10 h-auto hover:opacity-60 p-2 rounded-bl-lg`}
                    onClick={handleButtonClick}
                >
                    <img src={`/logo/${buttonImage}`} alt="Logo" />
                </button>
            </div>
        </div>
    );
}


