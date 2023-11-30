<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class MenuResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     * 
     * 
     */


    public function toArray($request)
    {
        $meals = [];
        foreach ($this -> meals as $m) {
            $meal = [
                'id' => $m -> id,
                'id_menu' => $m -> id_menu,
                'name' => $m -> name,
                'price' => $m -> price,
                'quantity' => $m -> quantity,
                'description' => $m -> description,
                'img_meal' => $m -> img_meal,
                
            ];
            array_push($meals,$meal);
        }
        // return parent::toArray($request);
        return [
            'id' => $this->id,
            'type' => $this->type,
            'img_Menu' => $this->img_Menu,
            'meals' => $meals
        ];
    }
}
