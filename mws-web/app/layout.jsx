import { AuthProvider } from '@/components/AuthProvider';
import createClient from '@/lib/supabase-server';
import GlobalNav from '@/components/GlobalNav';

import './globals.css';

// do not cache this layout
export const revalidate = 0;

export default async function RootLayout({ children }) {
  const supabase = createClient();

  const {
    data: { session },
  } = await supabase.auth.getSession();

  const accessToken = session?.access_token || null;

  return (
    <html lang="en">
      <AuthProvider accessToken={accessToken}>
        <body className="">
          <GlobalNav />

            <div className="">
   
               {children}

            </div>
        </body>
      </AuthProvider>
    </html>
  );
}
