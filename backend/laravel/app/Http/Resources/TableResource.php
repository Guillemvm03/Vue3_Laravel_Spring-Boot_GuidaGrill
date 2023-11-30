<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class TableResource extends JsonResource
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
        $menus = [];
        foreach ($this -> menus as $mn) {
            $menu = [
                'id' => $mn -> id,
                'type' => $mn -> type,
                'img_Menu' => $mn -> img_Menu,
                
            ];
            array_push($menus,$menu);
        }
        return [
            'id' => $this->id,
            'table_number' => $this->table_number,
            'capacity' => $this->capacity,
            'category' => $this->category,
            'available' => $this->available,
            'status' => $this->status,
            'img_table' => $this->img_table,
            'menus' => $menus
        ];
    }
}
