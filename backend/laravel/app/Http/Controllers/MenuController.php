<?php

namespace App\Http\Controllers;

use App\Models\Menu;
use Illuminate\Http\Request;
use App\Http\Resources\MenuResource;
use App\Http\Requests\StoreMenuRequest;
use App\Http\Requests\UpdateMenuRequest;



class MenuController extends Controller
{
  /**
   * Display a listing of the resource.
   */
  public function index()
  {
    return MenuResource::collection(Menu::all());
  }

  public function store(StoreMenuRequest $request)
  {
    return MenuResource::make(Menu::create($request->validated()));
  }


  public function show(string $id)
  {

    return MenuResource::make(Menu::where('id', $id)->firstOrFail());
  }

  /**
   * Update the specified resource in storage.
   */
  public function update(UpdateMenuRequest $request, string $id)
  {

    if (Menu::where('id', $id)->exists()) {
      $menu = Menu::find($id);

      $menu->update($request->validated());
      return MenuResource::make($menu);
    } else {
      return response()->json([
        "message" => "Menu not found"
      ], 404);
    }
  }

  /**
   * Remove the specified resource from storage.
   */
  public function destroy(string $id)
  {
    //
    if (Menu::where('id', $id)->exists()) {
      $menu = Menu::find($id);
      $menu->delete();
      return response()->json([
        "message" => "Menu deleted"
      ], 202);
    } else {
      return response()->json([
        "message" => "Menu not found"
      ], 404);
    }
  }
}
