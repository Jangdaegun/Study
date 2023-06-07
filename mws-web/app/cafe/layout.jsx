import Link from 'next/link';


export default function CafeLayout({ children }) {
  return (
    <>
      <header className="bg-gray-800 text-white py-4 px-6">
        <h1 className="text-xl">Header</h1>
      </header>
      <div className="flex">
      <aside className="bg-white text-gray-700 w-64 flex-shrink-0 p-6" style={{ height: '100vh' }}>
          <h2 className="text-lg mb-4">Sidebar</h2>
          <ul>
            <Link href = "/cafe/menu">
              <li className="mb-2">Menu Item 1</li>
            </Link>
            <li className="mb-2">Menu Item 2</li>
            <li className="mb-2">Menu Item 3</li>
          </ul>
        </aside>
        <main className="flex-1 p-6">
          <div className="">{children}</div>
        </main>
      </div>
    </>
  );
}
