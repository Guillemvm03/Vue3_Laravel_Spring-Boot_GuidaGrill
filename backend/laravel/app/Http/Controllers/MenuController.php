<?php
namespace App\Http\Controllers;

use App\Models\Menu;
use Illuminate\Http\Request;
use App\Http\Resources\MenuResource;

use App\Http\Requests\UpdateMenuRequest;
use App\Http\Requests\StoreMenuRequest;
use App\Http\Requests\StoreTableRequest;
use Illuminate\Contracts\Cache\Store;

class MenuController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //   return MenuResource::collection(Menu::all());
    }

    /**
     * Show the form for creating a new resource.
     */

     public function store(StoreTableRequest $request)
    {
        // return MenuResource::make(Menu::create($request->validated()));
    }
}