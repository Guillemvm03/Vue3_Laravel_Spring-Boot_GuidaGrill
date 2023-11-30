<?php

namespace App\Http\Controllers;

use App\Models\Meals;
use Illuminate\Http\Request;
use App\Http\Resources\mealsResource;

class mealsController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        return mealsResource::collection(Meals::all());

    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $data = $request->except(['meals']);
        $meals = Meals::whereIn('type', $request->meals)->get();
        $meals_id = [];
        foreach ($meals as $c) {
            array_push($meals_id, $c->id);
        }
  
        if (count($meals_id) > 0) {
            $meals = Meals::create($data);
            $meals->meals()->sync($meals_id);
            return mealsResource::make($meals);
        } else {
            return response()->json([
                "Status" => "Not found"
            ], 404);
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        return mealsResource::make(Meals::where('id', $id)->firstOrFail());

    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        if (Meals::where('id', $id)->exists()) {
            $meals = Meals::find($id);
    
          $meals->update($request->validated());
          return mealsResource::make($meals);
          }else {
          return response()->json([
            "message" => "Meal not found"
          ], 404);
        } 
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        if(Meals::where('id', $id)->exists()) {
            $meals = Meals::find($id);
            $meals->delete();
            return response()->json([
              "message" => "Meal deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Meal not found"
            ], 404);
          }
    }
}
