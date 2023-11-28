<?php

namespace App\Http\Controllers;

use App\Models\Table;
use Illuminate\Http\Request;
use App\Http\Resources\TableResource;

use App\Http\Requests\UpdateTableRequest;
use App\Http\Requests\StoreTableRequest;
use App\Models\Menu;

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
    //   return $request->validated();
      //   return TableResource::make(Table::create($request->validated()));
        $data = $request->except(['menus']);
        // return $request->menus;
        // dump(Menu::whereIn('type', $request->menus[0])->get());
        // die();
        $menus = Menu::whereIn('type', $request->menus)->get();
        // return $menus;
        // die();
        $menus_id = [];
        foreach ($menus as $c) {
            array_push($menus_id, $c->id);
        }
  
        if (count($menus_id) > 0) {
            $table = Table::create($data);
            $table->menus()->sync($menus_id);
            return TableResource::make($table);
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

        return TableResource::make(Table::where('id', $id)->firstOrFail());
    

    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateTableRequest $request, string $id)
    {
      $data = $request-> except(['menus']);
      $type = [];
      if ($request->menus !== null) {
        $type = $request->menus;
    }
    
    $menus = Menu::whereIn('type', $type)->get();
    $menus_id = [];
    foreach ($menus as $m) {
        array_push($menus_id, $m->id);
    }
   
    $update = Table::where('id', $id)->update($data);

    if ($update === 1) {
        if (count($menus_id) > 0) {
            $table = Table::where('id', $id)->firstOrFail();
            $table->menus()->detach();
            $table->menus()->sync($menus_id);
        }

        return response()->json([
            "Message" => "Updated correctly"
        ]);
    } else {
        return response()->json([
            "Status" => "Not found"
        ], 404);
    };
    //   if (Table::where('id', $id)->exists()) {
    //     $table = Table::find($id);

    //   $table->update($request->validated());
    //   return TableResource::make($table);
    //   }else {
    //   return response()->json([
    //     "message" => "Table not found"
    //   ], 404);
    // } 


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
              "message" => "Table deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Table not found"
            ], 404);
          }
    }
}
