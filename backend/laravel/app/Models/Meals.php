<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class Meals extends Model
{
    use HasFactory, HasApiTokens, Notifiable;

    public $timestamps = false;

    protected $table = 'meals';

    protected $fillable = [
        'id_menu',
        'name',
        'price',
        'quantity',        
        'description',
        'img_meal',
    ];

    public function menus(): BelongsTo {
        return $this->belongsTo(Menu::class, 'id_menu');
    }
}
