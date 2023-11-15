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

    public function definition(): array
    {
        return [
            
            'tablenumber' => fake()->numberBetween(1, 50),
            'capacity' => fake()->numberBetween(1,20),
            'category' => fake()->randomElement(['VIP', 'Singular', 'Families', 'Outside',]),
            'available' => fake()->boolean(),
            'status' => fake()->randomElement(['Occupied', 'Available', 'Reserved']),
        ];
    }
}
