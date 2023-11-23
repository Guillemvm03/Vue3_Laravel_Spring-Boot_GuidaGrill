<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class StoreTableRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, mixed>
     */
    public function rules()
    {
        return [
            'table_number' => 'required',
            'capacity' => 'required',
            'category' => 'required',
            'available' => 'required',
            'status' => 'required',
            'img_table' => 'required',
            'menus' => 'required', 'array: type, menus'
        ];
    }

    // public function messages()
    // {
    //     return [

    //         'table_number' => 'required',
    //         'capacity' => 'required',
    //         'category' => 'required',
    //         'available' => 'required',
    //         'status' => 'required',
    //     ];
    // }
   
    // public function attributes()
    // {
    //     return [

    //         'table_number' => 'required',
    //         'capacity' => 'required',
    //         'category' => 'required',
    //         'available' => 'required',
    //         'status' => 'required',
    //     ];
    // }
}
