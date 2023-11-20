<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Model>
 */
class TableFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */

        protected $model = \App\Models\Table::class;

    public function definition()
    {
        return [
            'table_number' => $this -> faker ->numberBetween(1, 50),
            'capacity' => $this -> faker->numberBetween(1,20),
            'category' => $this -> faker->randomElement(['VIP', 'Singular', 'Families', 'Outside',]),
            'available' => $this -> faker->boolean(),
            'status' => $this -> faker->randomElement(['Occupied', 'Available', 'Reserved']),
        ];
    }
}
