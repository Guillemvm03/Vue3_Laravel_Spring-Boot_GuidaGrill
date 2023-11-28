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
        //return false;
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
            'category' => 'string',
            'available' => 'required',
            'status' => 'string',
            'img_table' => 'string',
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
