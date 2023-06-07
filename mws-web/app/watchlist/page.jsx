import Link from 'next/link';
import { redirect } from 'next/navigation';

import createClient from '@/lib/supabase-server';


export default async function Profile() {
  const supabase = createClient();

  const videoIds = [
    "0UJ3znqK82A",
    "M7lc1UVf-VE",
    "u1zgFlCw8Aw",
  ];

  return (
    <>
    <div style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
  {videoIds.map((videoId) => (
    <iframe
      key={videoId}
      width="560"
      height="315"
      src={`https://www.youtube.com/embed/${videoId}?rel=0&modestbranding=1`}
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      allowFullScreen
    ></iframe>
  ))}
</div>

    </>
  );
}
