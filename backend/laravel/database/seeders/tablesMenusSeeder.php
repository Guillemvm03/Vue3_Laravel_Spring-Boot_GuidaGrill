<?php

namespace Database\Seeders;

use App\Models\Menu;
use App\Models\Table;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class tablesMenusSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $menus = Menu::factory()->count(5)->create();
        $tables = Table::factory()->count(20)->create();

        foreach ($tables as $table) {
            $table->menus()->attach($menus->random(rand(1, 4)));
        } //attach category in mesa
    }
}
