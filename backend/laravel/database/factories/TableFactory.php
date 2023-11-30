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
            'img_table' => $this -> faker->imageUrl(['https://th.bing.com/th/id/OIG.6tox5x0vX0jw8ZEMcC0o?pid=ImgGn','https://th.bing.com/th/id/OIG.hb2IHDiBv13lzHwMHS4b?pid=ImgGn','https://th.bing.com/th/id/OIG.fIX55Pzz0cGZKCIPEyxf?pid=ImgGn']),
        ];
    }
}
