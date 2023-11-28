<?php

namespace Database\Seeders;
use App\Models\Table;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class TableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run()
    {
        \App\Models\Table::factory(10)->create();

        // table::factory()->count(10)->create();

        \App\Models\Table::factory()->create([

            'tablenumber' => '1',
            'capacity' => '4',
            'category' => 'VIP',
            'available' => '1',
            'status' => 'Available',
            'img_table' => 'https://th.bing.com/th/id/OIG.6tox5x0vX0jw8ZEMcC0o?pid=ImgGn',
        ]);
    }
}
