<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class MesasSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        //
         \App\Models\Mesas::factory(10)->create();

        \App\Models\Mesas::factory()->create([
            'numMesa' => '1',
            'capacidad' => '4',
            'categoria' => '4',
            'disponible' => '1',
        ]);
    }
}
