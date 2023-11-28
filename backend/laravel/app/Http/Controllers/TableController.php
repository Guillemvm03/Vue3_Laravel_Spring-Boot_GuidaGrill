<?php

namespace App\Http\Controllers;

use App\Models\Table;
use Illuminate\Http\Request;
use App\Http\Resources\TableResource;

use App\Http\Requests\UpdateTableRequest;
use App\Http\Requests\StoreTableRequest;

class TableController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
          return TableResource::collection(Table::all());
    }

    /**
     * Show the form for creating a new resource.
     */


    /**
     * Store a newly created resource in storage.
     */

    public function store(StoreTableRequest $request)
    {
        return TableResource::make(Table::create($request->validated()));
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {

        return TableResource::make(Table::where('id', $id)->firstOrFail());

    }
    
    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateTableRequest $request, string $id)
    {
  
      if (Table::where('id', $id)->exists()) {
        $table = Table::find($id);

      $table->update($request->validated());
      return TableResource::make($table);
      }else {
      return response()->json([
        "message" => "Table not found"
      ], 404);
    } 


    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
        if(Table::where('id', $id)->exists()) {
            $table = Table::find($id);
            $table->delete();
            return response()->json([
              "message" => "Mesa deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Mesa not found"
            ], 404);
          }
    }
}
