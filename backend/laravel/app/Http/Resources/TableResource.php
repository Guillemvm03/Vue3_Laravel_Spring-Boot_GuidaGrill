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
        // return parent::toArray($request);
        return [
            'id' => $this->id,
            'table_number' => $this->table_number,
            'capacity' => $this->capacity,
            'category' => $this->category,
            'available' => $this->available,
            'status' => $this->status,


        ];
    }
}
