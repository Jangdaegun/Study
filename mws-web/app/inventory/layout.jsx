import Navigation from '@/components/Inventory/Navigation';

export default function InventoryLayout({ children }) {
  return (
    <>
      <Navigation />
      <div className="flex">

        <main className="flex-1 p-6 md:ml-56">
          <div className="">{children}</div>
        </main>
      </div>
    </>
  );
}
